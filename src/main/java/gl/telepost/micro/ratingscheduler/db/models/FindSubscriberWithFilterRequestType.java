package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.utils.PaginationType;

public class FindSubscriberWithFilterRequestType {
	private PaginationType pagination;
	private Short languageCode;
	private Short paymentMode;
	private Short ratingState;
	private Short statusId;
	private Integer blockSize;

	public PaginationType getPagination() {
		return pagination;
	}

	public void setPagination(PaginationType pagination) {
		this.pagination = pagination;
	}

	public Short getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(Short languageCode) {
		this.languageCode = languageCode;
	}

	public Short getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Short paymentMode) {
		this.paymentMode = paymentMode;
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

	public Integer getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(Integer blockSize) {
		this.blockSize = blockSize;
	}
}
