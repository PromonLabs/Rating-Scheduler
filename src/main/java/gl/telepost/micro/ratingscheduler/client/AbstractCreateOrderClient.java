package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.micro.ratingscheduler.db.models.AbstractOrderItem;
import gl.telepost.micro.ratingscheduler.utils.CreateOrderRequestType;
import gl.telepost.micro.ratingscheduler.utils.CreateOrderResponseType;
import gl.telepost.micro.ratingscheduler.utils.OrderUtil;

public abstract class AbstractCreateOrderClient {
	// protected CreateOrderResponseType validateAndSend(AbstractOrderItem
	// orderItem, String processName)
	// {
	// CreateOrderRequestType order = createOrderWithItems(processName,
	// orderItem);
	// final String validationFilePath =
	// OrderUtil.getValidationFilePath(processName);
	//
	// if (OrderUtil.isValidOrder(validationFilePath, orderItem)) {
	// return null;
	// // return sendOrder(order, new AuditBean());
	// }
	// else {
	// // throw new SoapClientException("Failed XSD validation for " +
	// processName);
	// }
	//
	// }
	//
	// final protected CreateOrderRequestType createOrderWithItems(final String
	// processName, final AbstractOrderItem... items) {
	// CreateOrderRequestType order = new CreateOrderRequestType();
	//
	// for (AbstractOrderItem item : items) {
	// item.setProcessName(processName);
	// order.getOrderItem().add(item);
	// }
	// return order;
	// }
}
