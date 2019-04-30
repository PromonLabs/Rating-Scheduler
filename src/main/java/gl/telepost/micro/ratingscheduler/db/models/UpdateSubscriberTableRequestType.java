package gl.telepost.micro.ratingscheduler.db.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UpdateSubscriberTableRequestType {
	private int subscriberId;
	private String orderStatus;
	private Date modifiedDate;

	public int getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId) {
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
