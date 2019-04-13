package gl.telepost.micro.ratingscheduler.utils;

public class StatusType
{
    private int statusCode;
    private String message;
    private String externalErrorName;
    private String externalErrorMessage;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExternalErrorName() {
        return externalErrorName;
    }

    public void setExternalErrorName(String externalErrorName) {
        this.externalErrorName = externalErrorName;
    }

    public String getExternalErrorMessage() {
        return externalErrorMessage;
    }

    public void setExternalErrorMessage(String externalErrorMessage) {
        this.externalErrorMessage = externalErrorMessage;
    }
}
