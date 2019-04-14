package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.utils.StatusType;

public class UpdateSubscriberStatusResponse
{
    protected StatusType status;

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
