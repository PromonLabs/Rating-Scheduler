package gl.telepost.micro.ratingscheduler.db.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SubscriberStatusRequest {
	private Long subscriberId;
	private String orderStatus;
	private Date modifiedDate;

	public Long getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
