package gl.telepost.micro.ratingscheduler.utils;

import java.util.Date;

public class SubscriberStatusType {
	private String accountId;
	private String serviceId;
	private Short ratingState;
	private Short statusId;
	private Short statusReasonId;
	private Short statusTypeId;
	private Date activeDt;
	private Date changeDt;
	private Date createDt;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Short getRatingState() {
		return ratingState;
	}

	public void setRatingState(Short ratingState) {
		this.ratingState = ratingState;
	}

	public Short getStatusId() {
		return statusId;
	}

	public void setStatusId(Short statusId) {
		this.statusId = statusId;
	}

	public Short getStatusReasonId() {
		return statusReasonId;
	}

	public void setStatusReasonId(Short statusReasonId) {
		this.statusReasonId = statusReasonId;
	}

	public Short getStatusTypeId() {
		return statusTypeId;
	}

	public void setStatusTypeId(Short statusTypeId) {
		this.statusTypeId = statusTypeId;
	}

	public Date getActiveDt() {
		return activeDt;
	}

	public void setActiveDt(Date activeDt) {
		this.activeDt = activeDt;
	}

	public Date getChangeDt() {
		return changeDt;
	}

	public void setChangeDt(Date changeDt) {
		this.changeDt = changeDt;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
}
