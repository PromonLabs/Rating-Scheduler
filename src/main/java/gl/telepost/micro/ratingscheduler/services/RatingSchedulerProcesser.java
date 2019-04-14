package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.Enums.OrderStatusSuspendedSubscriberEnum;
import gl.telepost.micro.ratingscheduler.client.RatingSchedulerClient;
import gl.telepost.micro.ratingscheduler.client.RetrieveSubscriberClient;
import gl.telepost.micro.ratingscheduler.db.models.*;
import gl.telepost.micro.ratingscheduler.utils.PaginationType;
import gl.telepost.micro.ratingscheduler.utils.ServiceType;
import gl.telepost.micro.ratingscheduler.utils.ShedulerConfig;
import gl.telepost.micro.ratingscheduler.utils.SubscriberStatusType;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

public class RatingSchedulerProcesser
{
    private static final short PREPAID_PAYMENT_MODE = 1;
    private static final short SUSPENDED_STATUS_ID = 3;
    private static final short SUSPENDED_RATING_STATE_S2 = 51;
    private static final short LANGUAGE_CODE = 1;

    private static final Short INVENTORY_TYPE_ID_IMSI = 2;
    private static final Short INVENTORY_TYPE_ID_MSISDN = 1;

    private static final String SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR = "5151";

    RatingSchedulerClient ratingSchedulerClient;

    public void excecuteCronJob()
    {
        int numberAttemptsIndex = 1;
        int numberAttempts = ShedulerConfig.getNumberAttempts();
        int retryFetchS2SubscribersDelay = ShedulerConfig.getRetryFetchS2SubscribersDelay();
        int findSubscriberBlockSize = ShedulerConfig.getFindSubscriberBlockSize();
        PaginationType pagination = new PaginationType();
        int startIndex = 0;
        int endIndex = findSubscriberBlockSize - 1;
        pagination.setStartIndex(startIndex);
        pagination.setEndIndex(endIndex);

        FindSubscriberWithFilterResponseType response = ratingSchedulerClient.findSubscriberWithFilter(
                LANGUAGE_CODE,SUSPENDED_RATING_STATE_S2,SUSPENDED_STATUS_ID,PREPAID_PAYMENT_MODE,
                pagination,findSubscriberBlockSize);

        List<SubscriberStatusType> subscriberStatusTypeList = response.getSubscriberStatus();

        while (subscriberStatusTypeList.isEmpty() && response.getTotalCount() == null && numberAttemptsIndex <= numberAttempts) {

//            LOG.info("Attempt number " + numberAttemptsIndex + " out of " + numberAttempts
//                    + " :Unable to retrieve SuspendedS2 subscribers. Trying again in " + retryFetchS2SubscribersDelay + " minutes");
            delay(retryFetchS2SubscribersDelay);
            numberAttemptsIndex++;

//            LOG.info("Retrying fetch S2 subscribers. Attempt number: " + numberAttemptsIndex);
            response = ratingSchedulerClient.findSubscriberWithFilter(LANGUAGE_CODE, SUSPENDED_RATING_STATE_S2, SUSPENDED_STATUS_ID,
                    PREPAID_PAYMENT_MODE, pagination, findSubscriberBlockSize);
            subscriberStatusTypeList = response.getSubscriberStatus();
        }
        if (numberAttemptsIndex > numberAttempts) {
//            LOG.info("Terminate S2 subscribers failed fetching subscribers after " + numberAttemptsIndex
//                    + " attempts. The task is scheduled to re-run in 1 day.");
            return;
        }
        int subscribersNumberTest = ShedulerConfig.findS2SubscribersTest();
        List<SubscriberStatusType> subscriberTestList = new ArrayList<SubscriberStatusType>();

        if (subscribersNumberTest > 0 && subscribersNumberTest >= subscriberStatusTypeList.size()) {
            for (int i = 0; i < subscribersNumberTest; i++) {
                subscriberTestList.add(subscriberStatusTypeList.get(i));
            }
            processSubscribers(subscriberTestList);
            return;
        }
    }


    public void delay(int minutes) {
        try {
            Thread.sleep(minutes * 60 * 1000); // 1000 milliseconds is one second.
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void processSubscribers(List<SubscriberStatusType> subscriberStatusTypeList)
    {
        for (SubscriberStatusType subscriberStatusType : subscriberStatusTypeList)
        {
            Long subscriberId = Long.valueOf(subscriberStatusType.getServiceId());
            DatabaseAccess da = new DatabaseAccess();
            SubscriberStatusResponse subscriberStatusResponse = da.getSubscriberRecord(subscriberId);

            boolean isOrderRequired = false;
            SubscriberCommandObject subscriberCommandObject = null;

            if (subscriberStatusResponse.getSubscriberId() == null)
            {
                ServiceType serviceType = fetchSubscriberDetails(subscriberStatusType.getServiceId());
                //need to implement this
//                subscriberCommandObject = subscriberCommandObject = validateSubscriberDetails(serviceType);

                if (!subscriberCommandObject.isS2())
                {
                    continue;
                }

                if (!subscriberCommandObject.isInfoValid())
                {
//                    LOG.debug("Error fetching subscribers details to generate order");
                    da.createSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED.getOrderStatus());
                    continue;
                }
                if (subscriberCommandObject.isImsiFoundInHLR())
                {
                    da.createSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_WAITING_CALLBACK.getOrderStatus());
                    isOrderRequired = true;
                }
                else
                 {
                    da.createSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_COMPLETE.getOrderStatus());
                    continue;
                }
            }
            else if (subscriberStatusResponse.getOrderStatus().equals(
                    OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED.getOrderStatus())) {

                ServiceType serviceType = fetchSubscriberDetails(subscriberStatusType.getServiceId());
//                subscriberCommandObject = validateSubscriberDetails(serviceType);

                if (!subscriberCommandObject.isS2()) {
                    continue;
                }

                if (!subscriberCommandObject.isInfoValid()) {
//                    LOG.debug("Error fetching subscribers details to generate order");
                    da.updateSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED.getOrderStatus());
                    continue;
                }

                if (subscriberCommandObject.isImsiFoundInHLR()) {
                    da.updateSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_WAITING_CALLBACK.getOrderStatus());
                    isOrderRequired = true;
                }
                else {
                    da.updateSubscriberRecord(subscriberId,
                            OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_COMPLETE.getOrderStatus());
                    continue;
                }
            }
//            if (isOrderRequired) {
//                isOrderRequired = false;
//                CreateTerminateSuspendedS2SubscriberOrder orderTerminateS2 = new CreateTerminateSuspendedS2SubscriberOrder(null);
//                orderTerminateS2.execute(subscriberCommandObject);
//            }
        }
    }

    /**
     *
     * Wrapper to GetServiceInformationv3 to catch and handle network connectivity exceptions
     *
     */
    protected ServiceType fetchSubscriberDetails(String serviceId) {
        ServiceType serviceType = new ServiceType();
        serviceType.setServiceId(serviceId);
        RetrieveSubscriberClient subscriberInformationClient = new RetrieveSubscriberClient(serviceType);
        try {
            return subscriberInformationClient.getService();
        }
        catch (RestClientException e) {
            return null;
        }
    }
}
