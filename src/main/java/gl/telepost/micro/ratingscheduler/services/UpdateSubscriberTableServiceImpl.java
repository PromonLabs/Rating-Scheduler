package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.client.RatingSchedulerClient;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterResponseType;
import gl.telepost.micro.ratingscheduler.db.models.StatusType;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableRequestType;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableResponseType;
import gl.telepost.micro.ratingscheduler.utils.PaginationType;
import gl.telepost.micro.ratingscheduler.utils.ShedulerConfig;

import org.springframework.stereotype.Service;

@Service
public class UpdateSubscriberTableServiceImpl
		implements
			UpdateSubscriberTableService {
	DatabaseAccess da;

	public UpdateSubscriberTableResponseType updateStatus(
			UpdateSubscriberTableRequestType request) {
		da = new DatabaseAccess();
		// LOG.debug("Updating subscriber status table");
		if ((Integer) request.getSubscriberId() != null) {
			da.updateSubscriberRecord(request.getSubscriberId(),
					request.getOrderStatus());
		}
		// setting the response
		UpdateSubscriberTableResponseType response = new UpdateSubscriberTableResponseType();
		StatusType status = new StatusType();
		status.setStatusCode(200);
		status.setMessage("SUCCESS");
		response.setStatus(status);
		return response;
	}

	RatingSchedulerClient ratingSchedulerClient = new RatingSchedulerClient();
	private static final short PREPAID_PAYMENT_MODE = 1;
	private static final short SUSPENDED_STATUS_ID = 3;
	private static final short SUSPENDED_RATING_STATE_S2 = 51;
	private static final short LANGUAGE_CODE = 1;

	private static final Short INVENTORY_TYPE_ID_IMSI = 2;
	private static final Short INVENTORY_TYPE_ID_MSISDN = 1;

	private static final String SOAP_CLIENT_ERROR_IMSI_NOT_FOUND_IN_HLR = "5151";

	public String excecuteCronJob() {
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
		return "success";

	}
}