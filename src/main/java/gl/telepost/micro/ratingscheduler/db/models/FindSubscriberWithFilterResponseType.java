package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.utils.StatusType;
import gl.telepost.micro.ratingscheduler.utils.SubscriberStatusType;

import java.util.List;

public class FindSubscriberWithFilterResponseType
{
    private Integer totalCount;
    private StatusType status;
    private List<SubscriberStatusType> subscriberStatus;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public List<SubscriberStatusType> getSubscriberStatus() {
        return subscriberStatus;
    }

    public void setSubscriberStatus(List<SubscriberStatusType> subscriberStatus) {
        this.subscriberStatus = subscriberStatus;
    }
}
