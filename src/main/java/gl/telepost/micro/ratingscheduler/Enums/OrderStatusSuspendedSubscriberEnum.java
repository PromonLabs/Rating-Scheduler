package gl.telepost.micro.ratingscheduler.Enums;

public enum OrderStatusSuspendedSubscriberEnum {
	ORDER_STATUS_WAITING_CALLBACK("waitingCallback"), ORDER_STATUS_SUSPENDEDS2_COMPLETE(
			"suspendedS2Complete"), ORDER_STATUS_SUSPENDEDS2_FETCH_ORDER_INFO_FAILED(
			"fetchOrderInfoFailed");

	private final String orderStatus;

	private OrderStatusSuspendedSubscriberEnum(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
}
