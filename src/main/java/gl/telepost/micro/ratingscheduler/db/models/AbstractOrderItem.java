package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.Enums.OrderProcessType;

import java.util.Date;

public abstract class AbstractOrderItem {
	protected String processName;
	protected OrderProcessType orderProcessType;
	protected Date preferredActionDate;
	protected String addonServiceCategory;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public OrderProcessType getOrderProcessType() {
		return orderProcessType;
	}

	public void setOrderProcessType(OrderProcessType orderProcessType) {
		this.orderProcessType = orderProcessType;
	}

	public Date getPreferredActionDate() {
		return preferredActionDate;
	}

	public void setPreferredActionDate(Date preferredActionDate) {
		this.preferredActionDate = preferredActionDate;
	}

	public String getAddonServiceCategory() {
		return addonServiceCategory;
	}

	public void setAddonServiceCategory(String addonServiceCategory) {
		this.addonServiceCategory = addonServiceCategory;
	}
}
