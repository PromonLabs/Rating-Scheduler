package gl.telepost.micro.ratingscheduler.utils;

public class ExternalIdType {
	protected String externalId;
	protected Short externalIdType;
	protected String displayName;
	protected String encryptionKey;

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Short getExternalIdType() {
		return externalIdType;
	}

	public void setExternalIdType(Short externalIdType) {
		this.externalIdType = externalIdType;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
}
