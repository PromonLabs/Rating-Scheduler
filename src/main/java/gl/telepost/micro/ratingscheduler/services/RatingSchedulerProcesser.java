package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.Enums.OrderStatusSuspendedSubscriberEnum;
import gl.telepost.micro.ratingscheduler.client.RatingSchedulerClient;
import gl.telepost.micro.ratingscheduler.client.RetrieveSubscriberClient;
import gl.telepost.micro.ratingscheduler.db.models.*;
import gl.telepost.micro.ratingscheduler.utils.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingSchedulerProcesser {

	RatingSchedulerClient ratingSchedulerClient = new RatingSchedulerClient();
	private static final short PREPAID_PAYMENT_MODE = 1;
	private static final short SUSPENDED_STATUS_ID = 3;
	private static final short SUSPENDED_RATING_STATE_S2 = 51;
	private static final short LANGUAGE_CODE = 1;

	private static final Short INVENTORY_TYPE_ID_IMSI = 2;
	private static final Short INVENTORY_TYPE_ID_MSISDN = 1;

	private static final String SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR = "5151";

	@Scheduled(cron = "* 0/5 * * * ?")
	public void excecuteCronJob() {
		int numberAttemptsIndex = 1;
		int numberAttempts = ShedulerConfig.getNumberAttempts(); // default is 3
		int retryFetchS2SubscribersDelay = ShedulerConfig
				.getRetryFetchS2SubscribersDelay(); // default is 10 mins
		int findSubscriberBlockSize = ShedulerConfig
				.getFindSubscriberBlockSize(); // default is 50
		PaginationType pagination = new PaginationType();
		int startIndex = 0;
		int endIndex = findSubscriberBlockSize - 1; // making sure totally 50
													// counts or block size
													// which is set in property
													// file
		pagination.setStartIndex(startIndex);
		pagination.setEndIndex(endIndex);

		// getting list of subscribers
		FindSubscriberWithFilterResponseType response = ratingSchedulerClient
				.findSubscriberWithFilter(LANGUAGE_CODE,
						SUSPENDED_RATING_STATE_S2, SUSPENDED_STATUS_ID,
						PREPAID_PAYMENT_MODE, pagination,
						findSubscriberBlockSize);
		System.out.println(response.getSubscriberStatus());
		// first subscriber block
		List<SubscriberStatusType> subscriberStatusTypeList = response
				.getSubscriberStatus();

		// checking the connection
		while (subscriberStatusTypeList.isEmpty()
				&& response.getTotalCount() == null
				&& numberAttemptsIndex <= numberAttempts) {

			// LOG.info("Attempt number " + numberAttemptsIndex + " out of " +
			// numberAttempts
			// +
			// " :Unable to retrieve SuspendedS2 subscribers. Trying again in "
			// + retryFetchS2SubscribersDelay + " minutes");
			delay(retryFetchS2SubscribersDelay);
			numberAttemptsIndex++;

			// LOG.info("Retrying fetch S2 subscribers. Attempt number: " +
			// numberAttemptsIndex);
			response = ratingSchedulerClient.findSubscriberWithFilter(
					LANGUAGE_CODE, SUSPENDED_RATING_STATE_S2,
					SUSPENDED_STATUS_ID, PREPAID_PAYMENT_MODE, pagination,
					findSubscriberBlockSize);
			subscriberStatusTypeList = response.getSubscriberStatus();
		}
		if (numberAttemptsIndex > numberAttempts) {
			// LOG.info("Terminate S2 subscribers failed fetching subscribers after "
			// + numberAttemptsIndex
			// + " attempts. The task is scheduled to re-run in 1 day.");
			return;
		}
		int subscribersNumberTest = ShedulerConfig.findS2SubscribersTest();
		List<SubscriberStatusType> subscriberTestList = new ArrayList<SubscriberStatusType>();

		if (subscribersNumberTest > 0
				&& subscribersNumberTest >= subscriberStatusTypeList.size()) {
			for (int i = 0; i < subscribersNumberTest; i++) {
				subscriberTestList.add(subscriberStatusTypeList.get(i));
			}
			processSubscribers(subscriberTestList);

			Integer totalCount = response.getTotalCount();

			// excecuting next block
			if (totalCount.intValue() >= findSubscriberBlockSize) {
				startIndex = startIndex + findSubscriberBlockSize;
				endIndex = endIndex + findSubscriberBlockSize;
				pagination.setStartIndex(startIndex);
				pagination.setEndIndex(endIndex);

				while (totalCount >= endIndex) {

					response = ratingSchedulerClient.findSubscriberWithFilter(
							LANGUAGE_CODE, SUSPENDED_RATING_STATE_S2,
							SUSPENDED_STATUS_ID, PREPAID_PAYMENT_MODE,
							pagination, findSubscriberBlockSize);

					// process next subscriber block
					subscriberStatusTypeList = response.getSubscriberStatus();
					processSubscribers(subscriberStatusTypeList);

					startIndex = startIndex + findSubscriberBlockSize;
					endIndex = endIndex + findSubscriberBlockSize;
					pagination.setStartIndex(startIndex);
					pagination.setEndIndex(endIndex);
				}
			}
			// return;
		}
	}

	public void delay(int minutes) {
		try {
			Thread.sleep(minutes * 60 * 1000); // 1000 milliseconds is one
												// second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void processSubscribers(
			List<SubscriberStatusType> subscriberStatusTypeList) {
		for (SubscriberStatusType subscriberStatusType : subscriberStatusTypeList) {
			Integer subscriberId = Integer.valueOf(subscriberStatusType
					.getServiceId());

			// getting subscriber record by passing serviceId
			DatabaseAccess da = new DatabaseAccess();
			SubscriberStatusResponse subscriberStatusResponse = da
					.getSubscriberRecord(subscriberId);

			boolean isOrderRequired = false;
			SubscriberCommandObject subscriberCommandObject = null;

			if (subscriberStatusResponse.getSubscriberId() == null) {
				ServiceType serviceType = fetchSubscriberDetails(subscriberStatusType
						.getServiceId());

				// need to implement this
				subscriberCommandObject = validateSubscriberDetails(serviceType);

				if (!subscriberCommandObject.isS2()) {
					continue;
				}

				if (!subscriberCommandObject.isInfoValid()) {
					// LOG.debug("Error fetching subscribers details to generate order");
					da.createSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED
									.getOrderStatus());
					continue;
				}
				if (subscriberCommandObject.isImsiFoundInHLR()) {
					da.createSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_WAITING_CALLBACK
									.getOrderStatus());
					isOrderRequired = true;
				} else {
					da.createSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_COMPLETE
									.getOrderStatus());
					continue;
				}
			} else if (subscriberStatusResponse
					.getOrderStatus()
					.equals(OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED
							.getOrderStatus())) {

				ServiceType serviceType = fetchSubscriberDetails(subscriberStatusType
						.getServiceId());
				// subscriberCommandObject =
				// validateSubscriberDetails(serviceType);

				if (!subscriberCommandObject.isS2()) {
					continue;
				}

				if (!subscriberCommandObject.isInfoValid()) {
					// LOG.debug("Error fetching subscribers details to generate order");
					da.updateSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED
									.getOrderStatus());
					continue;
				}

				if (subscriberCommandObject.isImsiFoundInHLR()) {
					da.updateSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_WAITING_CALLBACK
									.getOrderStatus());
					isOrderRequired = true;
				} else {
					da.updateSubscriberRecord(
							subscriberId,
							OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_COMPLETE
									.getOrderStatus());
					continue;
				}
			}
			// if (isOrderRequired) {
			// isOrderRequired = false;
			// CreateTerminateSuspendedS2SubscriberOrder orderTerminateS2 = new
			// CreateTerminateSuspendedS2SubscriberOrder(null);
			// orderTerminateS2.execute(subscriberCommandObject);
			// }
		}
	}

	/**
	 * Wrapper to GetServiceInformationv3 to catch and handle network
	 * connectivity exceptions
	 */
	protected ServiceType fetchSubscriberDetails(String serviceId) {
		ServiceType serviceType = new ServiceType();
		serviceType.setServiceId(serviceId);
		RetrieveSubscriberClient subscriberInformationClient = new RetrieveSubscriberClient(
				serviceType);
		try {
			return subscriberInformationClient.getService();
		} catch (RestClientException e) {
			return null;
		}
	}

	public SubscriberCommandObject validateSubscriberDetails(
			ServiceType serviceType) {
		SubscriberCommandObject subscriberCommandObject = new SubscriberCommandObject();
		subscriberCommandObject.setInfoValid(true);
		subscriberCommandObject.setS2(true);

		// check null for
		// ServiceType,getServiceStatus,getExternalIds,getExternalIds().getExternalId()
		if (serviceType == null && serviceType.getServiceStatus() == null
				&& serviceType.getExternalIds() == null
				&& serviceType.getExternalIds().getExternalId() == null) {
			subscriberCommandObject.setInfoValid(false);
			return subscriberCommandObject;
		}

		subscriberCommandObject.setServiceId(serviceType.getServiceId());

		// Validate suspended state S2
		if (Short.valueOf(serviceType.getServiceStatus()).shortValue() != SUSPENDED_RATING_STATE_S2) {
			// LOG.info("Warning: Subscriber " + serviceType.getServiceId() +
			// " has status " + serviceType.getServiceStatus());
			subscriberCommandObject.setS2(false);
			return subscriberCommandObject;
		}

		String imsi = null;

		// Validate and fetch IMSI and MSISDN
		for (ExternalIdType extId : serviceType.getExternalIds()
				.getExternalId()) {
			if (extId.getExternalIdType() == gl.telepost.micro.ratingscheduler.Enums.ExternalIdType.MSISDN
					.getExternalId()) {
				InventoryType inventoryType = new InventoryType();
				inventoryType.setInventoryTypeId(INVENTORY_TYPE_ID_MSISDN);
				inventoryType.setExternalId(extId.getExternalId());
				subscriberCommandObject.setMsisdnInventoryType(inventoryType);

			} else if (extId.getExternalIdType() == gl.telepost.micro.ratingscheduler.Enums.ExternalIdType.IMSI
					.getExternalId()) {
				InventoryType inventoryType = new InventoryType();
				inventoryType.setInventoryTypeId(INVENTORY_TYPE_ID_IMSI);
				imsi = extId.getExternalId();
				inventoryType.setExternalId(imsi);
				subscriberCommandObject.setImsiInventoryType(inventoryType);
			}
		}

		if (subscriberCommandObject.getMsisdnInventoryType() == null
				|| subscriberCommandObject.getImsiInventoryType() == null) {
			subscriberCommandObject.setInfoValid(false);
			return subscriberCommandObject;
		}

		if (imsi == null || imsi == "") {
			subscriberCommandObject.setInfoValid(false);
			return subscriberCommandObject;
		}
		Boolean isImsiFoundInHLR = getImsiFoundInHLR(imsi);

		if (isImsiFoundInHLR == null) {
			subscriberCommandObject.setInfoValid(false);
			return subscriberCommandObject;
		} else if (isImsiFoundInHLR == false) {
			subscriberCommandObject.setImsiFoundInHLR(false);
		} else if (isImsiFoundInHLR == true) {
			subscriberCommandObject.setImsiFoundInHLR(true);
		}
		return subscriberCommandObject;
	}

	protected Boolean getImsiFoundInHLR(String imsi) {

		// MobileSettingsInformationClient mobileSettingsClient = new
		// MobileSettingsInformationClient(null, imsi);
		//
		// MobileSettingsType mobileSettingsType;
		// try {
		// mobileSettingsType = mobileSettingsClient.getMobileSettings();
		// }
		// catch (SoapClientException e) {
		// if (e.getMessage().equals(SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR)) {
		// return false;
		// }
		// else {
		// return null;
		// }
		// }
		//
		// if (mobileSettingsType == null) {
		// return false;
		// }
		return true;
	}
}

// Boolean isImsiFoundInHLR = getImsiFoundInHLR(imsi);

// if (isImsiFoundInHLR == null) {
// subscriberCommandObject.setInfoValid(false);
// return subscriberCommandObject;
// }
// else if (isImsiFoundInHLR == false) {
// subscriberCommandObject.setImsiFoundInHLR(false);
// }
// else if (isImsiFoundInHLR == true) {
// subscriberCommandObject.setImsiFoundInHLR(true);
// }

// protected Boolean getImsiFoundInHLR(String imsi) {
//
// MobileSettingsInformationClient mobileSettingsClient = new
// MobileSettingsInformationClient(null, imsi);
//
// MobileSettingsType mobileSettingsType;
// try {
// mobileSettingsType = mobileSettingsClient.getMobileSettings();
// }
// catch (SoapClientException e) {
// if (e.getMessage().equals(SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR)) {
// return false;
// }
// else {
// return null;
// }
// }
//
// if (mobileSettingsType == null) {
// return false;
// }
// return true;
// }
// }

// protected SubscriberCommandObject validateSubscriberDetails(ServiceType
// serviceType) {
//
// SubscriberCommandObject subscriberCommandObject = new
// SubscriberCommandObject();
// subscriberCommandObject.setInfoValid(true);
// subscriberCommandObject.setS2(true);
//
// try {
// Preconditions.checkNotNull(serviceType, "serviceType is null");
// Preconditions.checkNotNull(serviceType.getServiceStatus(),
// "getServiceStatus is null");
// Preconditions.checkNotNull(serviceType.getExternalIds(),
// "getExternalIds is null");
// Preconditions.checkNotNull(serviceType.getExternalIds().getExternalId(),
// "getExternalIds().getExternalId() is null");
//
// }
// catch (NullPointerException npe) {
// subscriberCommandObject.setInfoValid(false);
// return subscriberCommandObject;
// }
//
// subscriberCommandObject.setServiceId(serviceType.getServiceId());
//
// // Validate suspended state S2
// if (Short.valueOf(serviceType.getServiceStatus()).shortValue() !=
// SUSPENDED_RATING_STATE_S2) {
// LOG.info("Warning: Subscriber " + serviceType.getServiceId() + " has status "
// + serviceType.getServiceStatus());
// subscriberCommandObject.setS2(false);
// return subscriberCommandObject;
// }
//
// String imsi = null;
//
// // Validate and fetch IMSI and MSISDN
// for (ExternalIdType extId : serviceType.getExternalIds().getExternalId()) {
// if (extId.getExternalIdType() ==
// gl.telepost.enums.ExternalIdType.MSISDN.getExternalId()) {
// InventoryType inventoryType = new InventoryType();
// inventoryType.setInventoryTypeId(INVENTORY_TYPE_ID_MSISDN);
// inventoryType.setExternalId(extId.getExternalId());
// subscriberCommandObject.setMsisdnInventoryType(inventoryType);
//
// }
// else if (extId.getExternalIdType() ==
// gl.telepost.enums.ExternalIdType.IMSI.getExternalId()) {
// InventoryType inventoryType = new InventoryType();
// inventoryType.setInventoryTypeId(INVENTORY_TYPE_ID_IMSI);
// imsi = extId.getExternalId();
// inventoryType.setExternalId(imsi);
// subscriberCommandObject.setImsiInventoryType(inventoryType);
// }
// }
//
// if (subscriberCommandObject.getMsisdnInventoryType() == null ||
// subscriberCommandObject.getImsiInventoryType() == null) {
// subscriberCommandObject.setInfoValid(false);
// return subscriberCommandObject;
// }
//
// if (imsi == null || imsi == "") {
// subscriberCommandObject.setInfoValid(false);
// return subscriberCommandObject;
// }
//
// Boolean isImsiFoundInHLR = getImsiFoundInHLR(imsi);
//
// if (isImsiFoundInHLR == null) {
// subscriberCommandObject.setInfoValid(false);
// return subscriberCommandObject;
// }
// else if (isImsiFoundInHLR == false) {
// subscriberCommandObject.setImsiFoundInHLR(false);
// }
// else if (isImsiFoundInHLR == true) {
// subscriberCommandObject.setImsiFoundInHLR(true);
// }
//
// return subscriberCommandObject;
// }
//
// /**
// * Delay method configurable in minutes. Used to configure a delay between
// re-attempts to run the task when connectivity failures occur
// */
// protected void delay(int minutes) {
// try {
// Thread.sleep(minutes * 60 * 1000); // 1000 milliseconds is one second.
// }
// catch (InterruptedException ex) {
// Thread.currentThread().interrupt();
// }
// }
//
// /**
// * Checks whether IMSI value is registered in the network
// *
// * @throws SoapClientException
// * */
// protected Boolean getImsiFoundInHLR(String imsi) {
//
// MobileSettingsInformationClient mobileSettingsClient = new
// MobileSettingsInformationClient(null, imsi);
//
// MobileSettingsType mobileSettingsType;
// try {
// mobileSettingsType = mobileSettingsClient.getMobileSettings();
// }
// catch (SoapClientException e) {
// if (e.getMessage().equals(SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR)) {
// return false;
// }
// else {
// return null;
// }
// }
//
// if (mobileSettingsType == null) {
// return false;
// }
// return true;
// }
// }
