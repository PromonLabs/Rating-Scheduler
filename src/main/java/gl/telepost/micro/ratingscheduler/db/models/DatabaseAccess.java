package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.repositories.SubscriberStatusRepo;
import gl.telepost.micro.ratingscheduler.repositories.SubscriberStatusResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class DatabaseAccess
{
    @Autowired
    private SubscriberStatusRepo subscriberStatusRepo;
    @Autowired
    private SubscriberStatusResponseRepo subscriberStatusResponseRepo;
    SubscriberStatusResponse subscriberStatusResponse;

    public SubscriberStatusResponse getSubscriberRecord(Long subscriberId)
    {
        SubscriberStatusRequest subscriberStatusRequest = subscriberStatusRepo.
                findSubscriberStatusBySubscriberId(subscriberId);
        subscriberStatusResponse.setSubscriberId(subscriberStatusRequest.getSubscriberId());
        subscriberStatusResponse.setOrderStatus(subscriberStatusRequest.getOrderStatus());
        subscriberStatusResponse.setModifiedDate(subscriberStatusRequest.getModifiedDate());
        subscriberStatusResponseRepo.save(subscriberStatusResponse);
        return subscriberStatusResponse;
    }

    public SubscriberStatusRequest createSubscriberRecord(Long subscriberId, String orderStatus)
    {
        SubscriberStatusRequest subscriberStatusRequest = new SubscriberStatusRequest();
        subscriberStatusRequest.setSubscriberId(subscriberId);
        subscriberStatusRequest.setOrderStatus(orderStatus);
        subscriberStatusRequest.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        subscriberStatusRepo.save(subscriberStatusRequest);
        return subscriberStatusRequest;
    }

    public SubscriberStatusRequest updateSubscriberRecord(Long subscriberId, String orderStatus)
    {
        SubscriberStatusRequest subscriberStatusRequest = subscriberStatusRepo.updateSubscriberRecord(orderStatus,
                new Timestamp(System.currentTimeMillis()),subscriberId);
        return subscriberStatusRequest;
    }
}
