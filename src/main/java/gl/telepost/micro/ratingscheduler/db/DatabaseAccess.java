package gl.telepost.micro.ratingscheduler.db;

import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatus;
import gl.telepost.micro.ratingscheduler.db.models.SubscriberRating;
import gl.telepost.micro.ratingscheduler.repositories.SubscriberRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DatabaseAccess
{
//    private static Logger log = Logger.getLogger(DatabaseAccess.class.getName());
    private SubscriberRating subscriberRating;
    private SubscriberStatus subscriberStatus;

    @Autowired
    private SubscriberRatingRepo subscriberRatingRepo;

    public SubscriberStatus getSubscriberStatusBySubscriberId(Long subscriberId)
    {
        subscriberRating = subscriberRatingRepo.getSubscriberRatingBySubscriberId(subscriberId);

        subscriberStatus = new SubscriberStatus();
        subscriberStatus.setSubscriberId(subscriberRating.getSubscriberId());
        subscriberStatus.setOrderStatus(subscriberRating.getOrderStatus());
        subscriberStatus.setModifiedDate(subscriberRating.getModifiedDate());
        return subscriberStatus;
    }

    public void createSubscriberRecord(Long subscriberId, String orderStatus)
    {
        subscriberRating = new SubscriberRating();
        subscriberRating.setSubscriberId(subscriberId);
        subscriberRating.setOrderStatus(orderStatus);
        subscriberRatingRepo.save(subscriberRating);
    }

    public void updateSubscriberRecord(Long subscriberId, String orderStatus)
    {
        subscriberRating = subscriberRatingRepo.getSubscriberRatingBySubscriberId(subscriberId);
        subscriberRating.setOrderStatus(orderStatus);
        subscriberRating.setModifiedDate(Date.from(Instant.now()));
        subscriberRatingRepo.save(subscriberRating);
    }

}
