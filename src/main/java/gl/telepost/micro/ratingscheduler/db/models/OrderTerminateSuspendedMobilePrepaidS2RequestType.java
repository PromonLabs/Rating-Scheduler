package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.Enums.OrderProcessType;
import gl.telepost.micro.ratingscheduler.utils.InventoriesType;

import java.util.Date;

public class OrderTerminateSuspendedMobilePrepaidS2RequestType
		extends
			AbstractOrderItem {
	protected String orderUser;
	protected String serviceId;
	protected String accountId;
	protected InventoriesType inventories;
	protected Date effectiveDate;
	protected String orderStatus;

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public InventoriesType getInventories() {
		return inventories;
	}

	public void setInventories(InventoriesType inventories) {
		this.inventories = inventories;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
