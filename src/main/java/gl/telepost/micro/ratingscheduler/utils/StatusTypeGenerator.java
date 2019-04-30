package gl.telepost.micro.ratingscheduler.utils;

public class StatusTypeGenerator {
	private static final String SUCCESSFUL_MESSAGE = "Success";
	private static final int SUCCESSFUL_STATUS_CODE = 0;

	public static final StatusType generateSuccessfulStatusType() {
		StatusType status = new StatusType();
		status.setMessage(SUCCESSFUL_MESSAGE);
		status.setStatusCode(SUCCESSFUL_STATUS_CODE);
		return status;
	}

	public static final StatusType generateStatusType(String errorMessage,
			int statusCode) {
		StatusType status = new StatusType();
		status.setMessage(errorMessage);
		status.setStatusCode(statusCode);
		return status;
	}

	// public static final StatusType generateStatusType(ESBServiceException
	// exception) {
	// StatusType status = new StatusType();
	// status.setMessage(exception.getError().getMessage());
	// status.setStatusCode(exception.getError().getStatusCode());
	// if (exception.getOriginalException() != null){
	// status.setExternalErrorName(exception.getOriginalException().getClass().getSimpleName());
	// status.setExternalErrorMessage(exception.getOriginalException().getMessage());
	// }
	// return status;
	// }

	public static int getSuccessStatusCode() {
		return SUCCESSFUL_STATUS_CODE;
	}

	public static String getSuccessMessage() {
		return SUCCESSFUL_MESSAGE;
	}
}
