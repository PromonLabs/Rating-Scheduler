package gl.telepost.micro.ratingscheduler.db.models;

public class InventoryType {
	protected String externalId;
	protected Integer inventoryId;
	protected Short inventoryTypeId;
	protected String displayName;
	protected Short inventoryIdResets;
	protected String serialNumber;
	protected Long sessionId;
	protected String encryptionKey;
	protected String key;
	protected Short keyType;
	protected Long topLevelContainerId;
	protected Integer topLevelContainerType;
	protected Short geographicRegionId;
	protected Integer statusId;
	protected Short vanityCode;
	protected Boolean assignable;
	protected Short state;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Short getInventoryTypeId() {
		return inventoryTypeId;
	}

	public void setInventoryTypeId(Short inventoryTypeId) {
		this.inventoryTypeId = inventoryTypeId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Short getInventoryIdResets() {
		return inventoryIdResets;
	}

	public void setInventoryIdResets(Short inventoryIdResets) {
		this.inventoryIdResets = inventoryIdResets;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Short getKeyType() {
		return keyType;
	}

	public void setKeyType(Short keyType) {
		this.keyType = keyType;
	}

	public Long getTopLevelContainerId() {
		return topLevelContainerId;
	}

	public void setTopLevelContainerId(Long topLevelContainerId) {
		this.topLevelContainerId = topLevelContainerId;
	}

	public Integer getTopLevelContainerType() {
		return topLevelContainerType;
	}

	public void setTopLevelContainerType(Integer topLevelContainerType) {
		this.topLevelContainerType = topLevelContainerType;
	}

	public Short getGeographicRegionId() {
		return geographicRegionId;
	}

	public void setGeographicRegionId(Short geographicRegionId) {
		this.geographicRegionId = geographicRegionId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Short getVanityCode() {
		return vanityCode;
	}

	public void setVanityCode(Short vanityCode) {
		this.vanityCode = vanityCode;
	}

	public Boolean getAssignable() {
		return assignable;
	}

	public void setAssignable(Boolean assignable) {
		this.assignable = assignable;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}
}
