package gl.telepost.micro.ratingscheduler.db.models;

import org.springframework.stereotype.Component;

@Component
public class UpdateSubscriberTableResponseType {
	private StatusType status;

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
}
