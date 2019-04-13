package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.client.RatingSchedulerClient;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterResponseType;
import gl.telepost.micro.ratingscheduler.utils.PaginationType;
import gl.telepost.micro.ratingscheduler.utils.ShedulerConfig;
import gl.telepost.micro.ratingscheduler.utils.SubscriberStatusType;

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

        while (subscriberStatusTypeList.isEmpty() && result.getTotalCount() == null && numberAttemptsIndex <= numberAttempts) {

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
            Integer subscriberId = Integer.valueOf(subscriberStatusType.getServiceId());

        }
    }
}
