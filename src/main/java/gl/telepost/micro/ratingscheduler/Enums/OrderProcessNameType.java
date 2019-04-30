package gl.telepost.micro.ratingscheduler.Enums;

public enum OrderProcessNameType {
	ORDER_MOVE_DDI_NUMBERS("orderMoveDDINumbers"), ORDER_ADDON_ADD_FIXED(
			"orderAddonAddFixed"), ORDER_ADDON_ADD_FLEX_USAGE_CONTROL_MOBILE(
			"orderAddonAddFlexUsageControlMobile"), ORDER_ADDON_ADD_GENERAL(
			"orderAddonAddGeneral"), ORDER_ADDON_ADD_MANUAL_GENERAL(
			"orderAddonAddManualGeneral"), ORDER_ADDON_ADD_NETWORK_SETTINGS_MOBILE(
			"orderAddonAddNetworkSettingsMobile"), ORDER_ADDON_ADD_SERVICE_PBX(
			"orderAddonAddServicePbx"), ORDER_ADDON_REMOVE_FIXED(
			"orderAddonRemoveFixed"), ORDER_ADDON_REMOVE_FLEX_USAGE_CONTROL_MOBILE(
			"orderAddonRemoveFlexUsageControlMobile"), ORDER_ADDON_REMOVE_GENERAL(
			"orderAddonRemoveGeneral"), ORDER_ADDON_REMOVE_MANUAL_GENERAL(
			"orderAddonRemoveManualGeneral"), ORDER_ADDON_REMOVE_NETWORK_SETTINGS_MOBILE(
			"orderAddonRemoveNetworkSettingsMobile"), ORDER_ADDON_REMOVE_SERVICE_PBX(
			"orderAddonRemoveServicePbx"), ORDER_CHANGE_ITEMIZED_INVOICE_FORMAT(
			"orderChangeItemizedInvoiceFormat"), ORDER_CHANGE_MODEM_DSL(
			"orderChangeModemDsl"), ORDER_CHANGE_NUMBER_FIXED_SERVICES(
			"orderChangeNumberFixedServices"), ORDER_CHANGE_NUMBER_MOBILE(
			"orderChangeNumberMobile"), ORDER_CHANGE_SIM_MOBILE(
			"orderChangeSimMobile"), ORDER_CHANGE_USERLIMIT_PBX(
			"orderChangeUserlimitPbx"), ORDER_FRAUD_LOCK_MOBILE(
			"orderFraudLockMobile"), ORDER_FRAUD_LOCK_SERVICE_GENERAL(
			"orderFraudLockServiceGeneral"), ORDER_FRAUD_UNLOCK_MOBILE(
			"orderFraudUnlockMobile"), ORDER_FRAUD_UNLOCK_SERVICE_GENERAL(
			"orderFraudUnlockServiceGeneral"), ORDER_MOVE_DSL("orderMoveDsl"), ORDER_MOVE_FIXED_SERVICES(
			"orderMoveFixedServices"), ORDER_MOVE_MPLS_FIXED_SERVICE(
			"orderMoveMplsFixedService"), ORDER_MOVE_PSTN_DSL(
			"orderMovePstnDsl"), ORDER_MOVE_SERVICE_GENERAL(
			"orderMoveServiceGeneral"), ORDER_NEW_DSL("orderNewDsl"), ORDER_NEW_DSL_ON_EXISTING_PSTN(
			"orderNewDslOnExistingPstn"), ORDER_NEW_MAIN_PBX("orderNewMainPbx"), ORDER_NEW_MOBILE_POSTPAID(
			"orderNewMobilePostpaid"), ORDER_NEW_MOBILE_PREPAID(
			"orderNewMobilePrepaid"), ORDER_NEW_MOBILE_BROADBAND(
			"orderNewMobileBroadband"), ORDER_NEW_FIXED_SERVICE(
			"orderNewFixedService"), ORDER_NEW_PREMIUM_SHORT_CODE(
			"orderNewPremiumShortCode"), ORDER_NEW_PSTN("orderNewPstn"), ORDER_NEW_PSTN_DSL(
			"orderNewPstnDsl"), ORDER_NEW_SERVICE_GENERAL(
			"orderNewServiceGeneral"), ORDER_NEW_SERVICE_WITH_ADDON_GENERAL(
			"orderNewServiceWithAddonGeneral"), ORDER_NEW_SUB_PBX(
			"orderNewSubPbx"), ORDER_REACTIVATE_DSL("orderReactivateDsl"), ORDER_REACTIVATE_MOBILE(
			"orderReactivateMobile"), ORDER_REACTIVATE_PBX("orderReactivatePbx"), ORDER_REACTIVATE_SERVICE_GENERAL(
			"orderReactivateServiceGeneral"), ORDER_REACTIVATE_AUTOMATIC_DSL(
			"orderReactivateAutomaticDsl"), ORDER_REACTIVATE_AUTOMATIC_MOBILE(
			"orderReactivateAutomaticMobile"), ORDER_REACTIVATE_AUTOMATIC_PBX(
			"orderReactivateAutomaticPbx"), ORDER_REACTIVATE_AUTOMATIC_SERVICE_GENERAL(
			"orderReactivateAutomaticServiceGeneral"), ORDER_SUSPEND_DSL(
			"orderSuspendDsl"), ORDER_SUSPEND_MOBILE("orderSuspendMobile"), ORDER_SUSPEND_PBX(
			"orderSuspendPbx"), ORDER_SUSPEND_SERVICE_GENERAL(
			"orderSuspendServiceGeneral"), ORDER_SWAP_OFFER_DSL(
			"orderSwapOfferDsl"), ORDER_SWAP_OFFER_POSTPAID_MOBILE(
			"orderSwapOfferPostpaidMobile"), ORDER_SWAP_OFFER_PREMIUM_SHORT_CODE(
			"orderSwapOfferPremiumShortCode"), ORDER_SWAP_OFFER_SERVICE_GENERAL(
			"orderSwapOfferServiceGeneral"), ORDER_SWAP_OFFER_MPLS_SERVICE_GENERAL(
			"orderSwapOfferMplsServiceGeneral"), ORDER_SWAP_OFFER_FIXED_SERVICE(
			"orderSwapOfferFixedService"), ORDER_TERMINATE_DSL(
			"orderTerminateDsl"), ORDER_TERMINATE_ISDN_2("orderTerminateIsdn2"), ORDER_TERMINATE_MAIN_PBX(
			"orderTerminateMainPbx"), ORDER_TERMINATE_ISDN_2_NO_BS_STEP(
			"orderTerminateIsdn2NoBsStep"), ORDER_TERMINATE_MAIN_PBX_NO_BS_STEP(
			"orderTerminateMainPbxNoBsStep"), ORDER_TERMINATE_MOBILE_POSTPAID(
			"orderTerminateMobilePostpaid"), ORDER_TERMINATE_MOBILE_PREPAID(
			"orderTerminateMobilePrepaid"), ORDER_TERMINATE_MOBILE_BROADBAND(
			"orderTerminateMobileBroadband"), ORDER_TERMINATE_PREMIUM_SHORT_CODE(
			"orderTerminatePremiumShortCode"), ORDER_TERMINATE_PSTN(
			"orderTerminatePstn"), ORDER_TERMINATE_PSTN_NO_BS_STEP(
			"orderTerminatePstnNoBsStep"), ORDER_TERMINATE_PSTN_DSL(
			"orderTerminatePstnDsl"), ORDER_TERMINATE_SERVICE_GENERAL(
			"orderTerminateServiceGeneral"), ORDER_TERMINATE_FIXED_SERVICE(
			"orderTerminateFixedService"), ORDER_TERMINATE_SUB_PBX(
			"orderTerminateSubPbx"), ORDER_TRANSFER_PHONE_SERVICE_TO_ACCOUNT(
			"orderTransferPhoneServiceToAccount"), ORDER_TRANSFER_SERVICE_TO_ACCOUNT(
			"orderTransferServiceToAccount"), ORDER_TRANSFER_BUNDLE_TO_ACCOUNT(
			"orderTransferBundleToAccount"), ORDER_PROVISION_ADDONS(
			"orderProvisionAddons"), ORDER_NEW_ISERFIK_ACCESS(
			"orderNewIserfikAccess"), ORDER_TERMINATE_ISERFIK_ACCESS(
			"orderTerminateIserfikAccess"), ORDER_MODIFY_ISERFIK_ACCESS(
			"orderModifyIserfikAccess"), ORDER_IST_NEW_TICKET(
			"orderISTNewTicket"), ORDER_IST_UPDATE_TICKET(
			"orderISTUpdateTicket"), ORDER_NEW_WS_LAN_LINK("orderNewWSLanLink"), ORDER_NEW_WSBSA(
			"orderNewWSBSA"), ORDER_NEW_WS_LOCAL_IP("orderNewWSLocalIP"), ORDER_NEW_WS_CONNECT_IP(
			"orderNewWSConnectIP"), ORDER_NEW_WS_NATIONAL_IP(
			"orderNewWSNationalIP"), ORDER_NEW_WS_GLOBAL_IP(
			"orderNewWSGlobalIP"), ORDER_NEW_WS_CO_LOCATION(
			"orderNewWSCoLocation"), ORDER_TERMINATE_WS_LAN_LINK(
			"orderTerminateWSLanLink"), ORDER_TERMINATE_WSBSA(
			"orderTerminateWSBSA"), ORDER_TERMINATE_WS_LOCAL_IP(
			"orderTerminateWSLocalIP"), ORDER_TERMINATE_WS_CONNECT_IP(
			"orderTerminateWSConnectIP"), ORDER_TERMINATE_WS_NATIONAL_IP(
			"orderTerminateWSNationalIP"), ORDER_TERMINATE_WS_GLOBAL_IP(
			"orderTerminateWSGlobalIP"), ORDER_TERMINATE_WS_CO_LOCATION(
			"orderTerminateWSCoLocation"), ORDER_SWAP_OFFER_WSBSA(
			"orderSwapOfferWSBSA"), ORDER_SWAP_OFFER_WS_LAN_LINK(
			"orderSwapOfferWSLanLink"), ORDER_SWAP_OFFER_WS_LOCAL_IP(
			"orderSwapOfferWSLocalIP"), ORDER_TERMINATE_SUSPENDED_MOBILE_PREPAID_S_2(
			"orderTerminateSuspendedMobilePrepaidS2"), ORDER_TERMINATE_MOBILE_BROADBAND_NO_BS_STEP(
			"orderTerminateMobileBroadbandNoBsStep"), ORDER_TERMINATE_MOBILE_PREPAID_NO_BS_STEP(
			"orderTerminateMobilePrepaidNoBsStep"), ORDER_ADDON_ADD_SIP_TRUNK(
			"orderAddonAddSipTrunk"), ORDER_ADDON_MODIFY_SIP_TRUNK(
			"orderAddonModifySipTrunk"), ORDER_ADDON_REMOVE_SIP_TRUNK(
			"orderAddonRemoveSipTrunk"), ORDER_ADDON_RE_PROVISION_SIP_TRUNK(
			"orderAddonReProvisionSipTrunk"), ORDER_RESET_PILOT_PASSWORD(
			"orderResetPilotPassword"), ORDER_APPROVE_INVOICE_DISPUTE(
			"orderApproveInvoiceDispute"), ORDER_REFILL_PREPAID_SERVICE_BALANCE(
			"orderRefillPrepaidServiceBalance"), ORDER_ADDON_REMOVE_DDI_NUMBERS(
			"orderAddonRemoveDDINumbers"), ORDER_ADDON_ADD_DDI_NUMBERS(
			"orderAddonAddDDINumbers"), ORDER_REGISTER_TUSASS_2(
			"orderRegisterTusass2"), ORDER_UPGRADE_DOWNGRADE_TUSASS_2(
			"orderUpgradeDowngradeTusass2"), ORDER_SWAP_TUSASS_2_TO_NORMAL_TUSASS(
			"orderSwapTusass2ToNormalTusass"), ORDER_REGISTER_MOBILE_POSTPAID_TO_TUSASS_2(
			"orderRegisterMobilePostpaidToTusass2"), ORDER_UPGRADE_DOWNGRADE_TUSASS_HOME(
			"orderUpgradeDowngradeTusassHome"), ORDER_REGISTER_ADSL_POSTPAID_TO_TUSASS_HOME(
			"orderRegisterADSLPostpaidToTusassHome"), ORDER_TERMINATE_TUSASS_HOME(
			"orderTerminateTusassHome"), ORDER_REGISTER_NEW_TUSASS_HOME(
			"orderRegisterNewTusassHome"), ORDER_MODEM_RETURN(
			"orderModemReturn"), ORDER_NEW_SERVICE_WITH_SIP_TRUNK_ADDON(
			"orderNewServiceWithSipTrunkAddon"), ORDER_ADDON_ADD_SIP_TRUNK_TO_BEARER(
			"orderAddonAddSipTrunkToBearer"), ORDER_SIP_TRUNK_AS_ADDON(
			"orderSipTrunkAsAddon"), ORDER_TERMINATE_SIP_TRUNK(
			"orderTerminateSipTrunk"), ORDER_TERMINATE_SIP_TRUNK_WITH_BEARER(
			"orderTerminateSipTrunkWithBearer"), ORDER_MODIFY_SIP_TRUNK(
			"orderModifySipTrunk"), ORDER_PROCESS_SIP_TRUNK_NUMBERS_TO_ADD(
			"orderProcessSipTrunkNumbersToAdd"), ORDER_PROCESS_SIP_TRUNK_NUMBERS_TO_REMOVE(
			"orderProcessSipTrunkNumbersToRemove"), ORDER_PROCESS_SIP_TRUNK_UPDATE(
			"orderProcessSipTrunkUpdate"), ORDER_PROCESS_SIP_TRUNK_NUMBERS_TO_MIGRATE_SINGLE(
			"orderProcessSipTrunkNumbersToMigrateSingle"), ORDER_SIP_TRUNK_TRANSFER_SERVICE_TO_ACCOUNT(
			"orderSipTrunkTransferServiceToAccount"), ORDER_PROCESS_SIP_TRUNK_NUMBERS_TO_MIGRATE_ADD_DDI(
			"orderProcessSipTrunkNumbersToMigrateAddDdi"), ORDER_PROCESS_SIP_TRUNK_NUMBERS_TO_MIGRATE_REMOVE_DDI(
			"orderProcessSipTrunkNumbersToMigrateRemoveDdi"), ORDER_MIGRATE_SIP_TRUNK_DDI_CONTAINER(
			"orderMigrateSipTrunkDDIContainer"), ORDER_REGISTER_MOBILE_PREPAID_TO_MOBILE_POSTPAID(
			"orderRegisterMobilePrepaidToMobilePostpaid"), ORDER_REGISTER_MOBILE_FIRST(
			"orderRegisterMobileFirst"), ORDER_UPGRADE_DOWNGRADE_MOBILE_FIRST(
			"orderUpgradeDowngradeMobileFirst"), ORDER_TERMINATE_MOBILE_FIRST(
			"orderTerminateMobileFirst"), ORDER_CHANGE_MODEM_MOBILE_FIRST(
			"orderChangeModemMobileFirst"), ORDER_TRANSFER_DSL_SERVICE_TO_ACCOUNT(
			"orderTransferDslServiceToAccount");
	private final String value;

	OrderProcessNameType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static OrderProcessNameType fromValue(String v) {
		for (OrderProcessNameType c : OrderProcessNameType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
