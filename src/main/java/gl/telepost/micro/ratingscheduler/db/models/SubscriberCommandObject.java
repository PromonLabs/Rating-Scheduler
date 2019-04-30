package gl.telepost.micro.ratingscheduler.db.models;

public class SubscriberCommandObject {
	private boolean isS2;
	private boolean isImsiFoundInHLR;
	private InventoryType imsiInventoryType;
	private InventoryType msisdnInventoryType;
	private String serviceId;
	private boolean infoValid;

	public boolean isS2() {
		return isS2;
	}

	public void setS2(boolean s2) {
		isS2 = s2;
	}

	public boolean isImsiFoundInHLR() {
		return isImsiFoundInHLR;
	}

	public void setImsiFoundInHLR(boolean imsiFoundInHLR) {
		isImsiFoundInHLR = imsiFoundInHLR;
	}

	public InventoryType getImsiInventoryType() {
		return imsiInventoryType;
	}

	public void setImsiInventoryType(InventoryType imsiInventoryType) {
		this.imsiInventoryType = imsiInventoryType;
	}

	public InventoryType getMsisdnInventoryType() {
		return msisdnInventoryType;
	}

	public void setMsisdnInventoryType(InventoryType msisdnInventoryType) {
		this.msisdnInventoryType = msisdnInventoryType;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public boolean isInfoValid() {
		return infoValid;
	}

	public void setInfoValid(boolean infoValid) {
		this.infoValid = infoValid;
	}
}
