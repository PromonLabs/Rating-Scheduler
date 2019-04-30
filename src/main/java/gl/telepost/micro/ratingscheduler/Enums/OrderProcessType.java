package gl.telepost.micro.ratingscheduler.Enums;

public enum OrderProcessType {
	MOBILE("Mobile"), MOBILE_BROADBAND("MobileBroadband"), BROADBAND(
			"Broadband"), BROADBAND_PSTN("Broadband+PSTN"), PSTN("PSTN"), ISDN_2(
			"ISDN2"), ISDN_30("ISDN30"), ISERFIK("Iserfik"), LAN_LINK("LanLink"), LEASED_LINES(
			"LeasedLines"), NETWORK_MPLS("Network(MPLS)"), VSAT("VSAT"), PREMIUM_SHORT_CODE(
			"PremiumShortCode"), IRIDIUM("Iridium"), ACCOUNT_OFFERS(
			"AccountOffers"), ADMINISTRATION("Administration"), MODIFY_ADDONS(
			"ModifyAddons"), ISERFIK_ACCESS("IserfikAccess"), IS_TICKETING(
			"ISTicketing"), WHOLESALE("Wholesale"), SHIP_RADIO("ShipRadio");

	private final String value;

	OrderProcessType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static OrderProcessType fromValue(String v) {
		for (OrderProcessType c : OrderProcessType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
