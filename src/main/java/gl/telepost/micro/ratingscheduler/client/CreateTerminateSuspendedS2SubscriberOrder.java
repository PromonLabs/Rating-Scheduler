package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.micro.ratingscheduler.Enums.OrderProcessNameType;
import gl.telepost.micro.ratingscheduler.Enums.OrderProcessType;
import gl.telepost.micro.ratingscheduler.Enums.OrderStatusSuspendedSubscriberEnum;
import gl.telepost.micro.ratingscheduler.db.models.AbstractOrderItem;
import gl.telepost.micro.ratingscheduler.db.models.OrderTerminateSuspendedMobilePrepaidS2RequestType;
import gl.telepost.micro.ratingscheduler.db.models.SubscriberCommandObject;
import gl.telepost.micro.ratingscheduler.utils.CreateOrderResponseType;
import gl.telepost.micro.ratingscheduler.utils.InventoriesType;

import java.sql.Timestamp;

public class CreateTerminateSuspendedS2SubscriberOrder {
	private static final String TASK_SCHEDULER_PROCESS = "Task scheduler process";

	protected OrderTerminateSuspendedMobilePrepaidS2RequestType constructTerminateSuspendedS2(
			SubscriberCommandObject subscriberCommandObject) {
		OrderTerminateSuspendedMobilePrepaidS2RequestType request = new OrderTerminateSuspendedMobilePrepaidS2RequestType();
		InventoriesType inventories = new InventoriesType();
		inventories.getInventory().add(
				subscriberCommandObject.getImsiInventoryType());
		inventories.getInventory().add(
				subscriberCommandObject.getMsisdnInventoryType());

		request.setInventories((inventories));
		request.setServiceId(subscriberCommandObject.getServiceId());
		request.setOrderUser(TASK_SCHEDULER_PROCESS);
		request.setOrderStatus(OrderStatusSuspendedSubscriberEnum.ORDER_STATUS_SUSPENDEDS2_COMPLETE
				.getOrderStatus());

		return request;
	}

	public CreateOrderResponseType execute(
			SubscriberCommandObject subscriberCommandObject) {
		OrderTerminateSuspendedMobilePrepaidS2RequestType orderItem = constructTerminateSuspendedS2(subscriberCommandObject);

		// set order specific fields
		orderItem
				.setProcessName(OrderProcessNameType.ORDER_TERMINATE_SUSPENDED_MOBILE_PREPAID_S_2
						.value());
		orderItem.setOrderProcessType(OrderProcessType.MOBILE);
		orderItem.setPreferredActionDate(new Timestamp(System
				.currentTimeMillis()));

		return null;
	}
}
