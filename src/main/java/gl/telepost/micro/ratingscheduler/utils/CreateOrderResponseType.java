package gl.telepost.micro.ratingscheduler.utils;

import java.util.Date;

public class CreateOrderResponseType {
	protected StatusType status;
	protected String processName;
	protected String orderId;
	protected Long ticketId;
	protected Date ticketCreatedDate;

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Date getTicketCreatedDate() {
		return ticketCreatedDate;
	}

	public void setTicketCreatedDate(Date ticketCreatedDate) {
		this.ticketCreatedDate = ticketCreatedDate;
	}
}
