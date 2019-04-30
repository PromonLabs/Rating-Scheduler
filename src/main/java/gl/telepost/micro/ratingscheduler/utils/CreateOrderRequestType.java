package gl.telepost.micro.ratingscheduler.utils;

import gl.telepost.micro.ratingscheduler.db.models.AbstractOrderItem;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderRequestType {
	protected List<AbstractOrderItem> orderItem;

	public List<AbstractOrderItem> getOrderItem() {
		if (orderItem == null) {
			orderItem = new ArrayList<AbstractOrderItem>();
		}
		return this.orderItem;
	}
}
