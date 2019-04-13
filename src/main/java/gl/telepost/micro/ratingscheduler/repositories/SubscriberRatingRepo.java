package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.SubscriberRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SubscriberRatingRepo extends JpaRepository<SubscriberRating, Long>
{
    @Query(value = "SELECT es.subscriber_id, es.order_status, es.modified_date FROM subscriber_rating.subscriber_state es WHERE es.subscriber_id = ?1")
    SubscriberRating getSubscriberRatingBySubscriberId(Long subscriberId);
}