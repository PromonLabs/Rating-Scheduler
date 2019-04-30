package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatus;
import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatusRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberStatusRepo
		extends
			JpaRepository<SubscriberStatus, Integer> {
	SubscriberStatus findBySubscriberId(Integer subscriberId);
	// SubscriberStatusRequest findSubscriberStatusBySubscriberId(Long
	// subscriberId);
	// @Query(value =
	// "UPDATE subscriber_rating.subscriber_state SET order_status = :orderStatus, modified_date = :modifiedDate "
	// +"WHERE subscriber_id = :subscriberId")
	// SubscriberStatusRequest updateSubscriberRecord(
	// @Param("orderStatus") String orderStatus,
	// @Param("modifiedDate") Date modifiedDate,
	// @Param("subscriberId") Long subscriberId);
}
