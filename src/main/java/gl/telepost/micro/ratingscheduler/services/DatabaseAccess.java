package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatus;
import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatusResponse;
import gl.telepost.micro.ratingscheduler.repositories.SubscriberStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DatabaseAccess {

	@Autowired
	private SubscriberStatusRepo subscriberStatusRepo;
	SubscriberStatusResponse subscriberStatusResponse = new SubscriberStatusResponse();

	public SubscriberStatusResponse getSubscriberRecord(Integer subscriberId) {
		SubscriberStatus subscriberStatusRequest = subscriberStatusRepo
				.findBySubscriberId(subscriberId);
		subscriberStatusResponse.setSubscriberId(subscriberStatusRequest
				.getSubscriberId());
		subscriberStatusResponse.setOrderStatus(subscriberStatusRequest
				.getOrderStatus());
		subscriberStatusResponse.setModifiedDate(subscriberStatusRequest
				.getModifiedDate());
		subscriberStatusRepo.save(subscriberStatusRequest);
		return subscriberStatusResponse;
	}

	public SubscriberStatus createSubscriberRecord(Integer subscriberId,
			String orderStatus) {
		SubscriberStatus subscriberStatusRequest = new SubscriberStatus();
		subscriberStatusRequest.setSubscriberId(subscriberId);
		subscriberStatusRequest.setOrderStatus(orderStatus);
		subscriberStatusRequest.setModifiedDate(new Timestamp(System
				.currentTimeMillis()));
		subscriberStatusRepo.save(subscriberStatusRequest);
		return subscriberStatusRequest;
	}
	public SubscriberStatus updateSubscriberRecord(Integer subscriberId,
			String orderStatus) {
		SubscriberStatus subscriberStatus = subscriberStatusRepo
				.findBySubscriberId(subscriberId);
		subscriberStatus.setOrderStatus(orderStatus);
		subscriberStatus.setModifiedDate(new Timestamp(System
				.currentTimeMillis()));
		subscriberStatusRepo.save(subscriberStatus);
		return subscriberStatus;
	}
}