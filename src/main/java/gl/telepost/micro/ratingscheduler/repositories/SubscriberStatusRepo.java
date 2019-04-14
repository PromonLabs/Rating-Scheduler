package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatusRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface SubscriberStatusRepo extends JpaRepository<SubscriberStatusRequest, Long>
{
    SubscriberStatusRequest findSubscriberStatusBySubscriberId(Long subscriberId);
    @Query(value = "UPDATE subscriber_rating.subscriber_state SET order_status = :orderStatus, modified_date = :modifiedDate "
            +"WHERE subscriber_id = :subscriberId")
    SubscriberStatusRequest updateSubscriberRecord(
            @Param("orderStatus") String orderStatus,
            @Param("modifiedDate") Date modifiedDate,
            @Param("subscriberId") Long subscriberId);
}
