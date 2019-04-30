package gl.telepost.micro.ratingscheduler.Enums;

public enum ExternalIdType {
	MSISDN("MSISDN", 1), IMSI("IMSI", 2), CPR("CPR", 3), ACCOUNT_ID(
			"Account ID", 4), DSL_ID("DSL ID", 5), LINE_ID("Line ID", 6), ICC_ID(
			"ICC ID", 7), PASSPORT_ID("Passport ID", 8), GER("GER", 9), MODEM_ID(
			"Modem ID", 10), MPLS_ID("MPLS ID", 11), VPN_ID("VPN ID", 12), INTERNET_ID(
			"Internet ID", 13), PRIMARY_NUMBER("Primary Number", 14), MAC_ADDRESS(
			"Mac Address", 15), LANLINK_ID("LanLink ID", 16), VSAT_ID(
			"VSAT ID", 17), CODE("Code", 18), CVR("CVR", 19), PHONE_NUMBER(
			"Phone Number", 20), ICC_ID_IRIDIUM("ICC ID Iridium", 21), IMSI_IRIDIUM(
			"IMSI Iridium", 22), IMS("IMS", 27), LINKSUB_ID("LinkSubId", 28), TEST_DSL(
			"Test_DSL", 29), IRIDIUM_IMEI("Iridium IMEI", 44), SHIP_RADIO(
			"Ship Radio", 34), EMAIL("E-mail", 38), WS_CIRCUIT_ID(
			"WS Circuit Id", 50);

	private String name;
	private int externalId;

	private ExternalIdType(String name, int externalId) {
		this.name = name;
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public short getExternalId() {
		return (short) this.externalId;
	}
}
