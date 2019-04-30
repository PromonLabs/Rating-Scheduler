package gl.telepost.micro.ratingscheduler.utils;

import gl.telepost.micro.ratingscheduler.db.models.InventoryType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceType {
	protected ContactType serviceUser;
	protected String serviceId;
	protected String type;
	protected String shortDescription;
	protected String description;
	protected String name;
	protected Short languageCode;
	protected String cpr;
	protected String ger;
	protected String cvr;
	protected PassportType passport;
	protected AddressType address;
	protected ServiceType.PricePlans pricePlans;
	protected SpendingControlType spendingControl;
	protected String accountId;
	protected String contactId;
	protected ServiceType.Addons addons;
	protected ServiceType.Balances balances;
	protected Date expiryDate;
	protected String recordStatus;
	protected String serviceStatus;
	protected Integer offerId;
	protected Boolean exDirectory;
	protected String effectiveDate;
	protected String waiveActivation;
	protected String taxRegion;
	protected String mainPbx;
	protected OfferType offer;
	protected Boolean isPublic;
	protected Date activationDate;
	protected PbxDataType pbxData;
	protected Short serviceIdResets;
	protected BigInteger serviceCategoryId;
	protected ExtendedDataType extendedData;
	protected ServiceType.Inventories inventories;
	protected ServiceType.ExternalIds externalIds;
	protected NonRecurringChargesType nonRecurringCharges;
	protected String ratingStatus;
	protected AddressType bAddress;
	protected List<ExtendedDataType> extendedDataList;
	protected ServiceType.Accumulators accumulators;

	public ContactType getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(ContactType serviceUser) {
		this.serviceUser = serviceUser;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(Short languageCode) {
		this.languageCode = languageCode;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getGer() {
		return ger;
	}

	public void setGer(String ger) {
		this.ger = ger;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}

	public PassportType getPassport() {
		return passport;
	}

	public void setPassport(PassportType passport) {
		this.passport = passport;
	}

	public AddressType getAddress() {
		return address;
	}

	public void setAddress(AddressType address) {
		this.address = address;
	}

	public PricePlans getPricePlans() {
		return pricePlans;
	}

	public void setPricePlans(PricePlans pricePlans) {
		this.pricePlans = pricePlans;
	}

	public SpendingControlType getSpendingControl() {
		return spendingControl;
	}

	public void setSpendingControl(SpendingControlType spendingControl) {
		this.spendingControl = spendingControl;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public Addons getAddons() {
		return addons;
	}

	public void setAddons(Addons addons) {
		this.addons = addons;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Boolean getExDirectory() {
		return exDirectory;
	}

	public void setExDirectory(Boolean exDirectory) {
		this.exDirectory = exDirectory;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getWaiveActivation() {
		return waiveActivation;
	}

	public void setWaiveActivation(String waiveActivation) {
		this.waiveActivation = waiveActivation;
	}

	public String getTaxRegion() {
		return taxRegion;
	}

	public void setTaxRegion(String taxRegion) {
		this.taxRegion = taxRegion;
	}

	public String getMainPbx() {
		return mainPbx;
	}

	public void setMainPbx(String mainPbx) {
		this.mainPbx = mainPbx;
	}

	public OfferType getOffer() {
		return offer;
	}

	public void setOffer(OfferType offer) {
		this.offer = offer;
	}

	public Boolean getPublic() {
		return isPublic;
	}

	public void setPublic(Boolean aPublic) {
		isPublic = aPublic;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public PbxDataType getPbxData() {
		return pbxData;
	}

	public void setPbxData(PbxDataType pbxData) {
		this.pbxData = pbxData;
	}

	public Short getServiceIdResets() {
		return serviceIdResets;
	}

	public void setServiceIdResets(Short serviceIdResets) {
		this.serviceIdResets = serviceIdResets;
	}

	public BigInteger getServiceCategoryId() {
		return serviceCategoryId;
	}

	public void setServiceCategoryId(BigInteger serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}

	public ExtendedDataType getExtendedData() {
		return extendedData;
	}

	public void setExtendedData(ExtendedDataType extendedData) {
		this.extendedData = extendedData;
	}

	public Inventories getInventories() {
		return inventories;
	}

	public void setInventories(Inventories inventories) {
		this.inventories = inventories;
	}

	public ExternalIds getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(ExternalIds externalIds) {
		this.externalIds = externalIds;
	}

	public NonRecurringChargesType getNonRecurringCharges() {
		return nonRecurringCharges;
	}

	public void setNonRecurringCharges(
			NonRecurringChargesType nonRecurringCharges) {
		this.nonRecurringCharges = nonRecurringCharges;
	}

	public String getRatingStatus() {
		return ratingStatus;
	}

	public void setRatingStatus(String ratingStatus) {
		this.ratingStatus = ratingStatus;
	}

	public AddressType getbAddress() {
		return bAddress;
	}

	public void setbAddress(AddressType bAddress) {
		this.bAddress = bAddress;
	}

	public List<ExtendedDataType> getExtendedDataList() {
		return extendedDataList;
	}

	public void setExtendedDataList(List<ExtendedDataType> extendedDataList) {
		this.extendedDataList = extendedDataList;
	}

	public Accumulators getAccumulators() {
		return accumulators;
	}

	public void setAccumulators(Accumulators accumulators) {
		this.accumulators = accumulators;
	}

	public static class PricePlans {
		protected List<PricePlanType> pricePlan;

		public List<PricePlanType> getPricePlan() {
			if (pricePlan == null) {
				pricePlan = new ArrayList<PricePlanType>();
			}
			return this.pricePlan;
		}
	}

	public static class Addons {
		protected List<OfferType> addon;

		public List<OfferType> getAddon() {
			if (addon == null) {
				addon = new ArrayList<OfferType>();
			}
			return this.addon;
		}
	}

	public static class Balances {
		protected List<BalanceType> balance;

		public List<BalanceType> getBalance() {
			if (balance == null) {
				balance = new ArrayList<BalanceType>();
			}
			return this.balance;
		}
	}

	public static class Inventories {
		protected List<InventoryType> inventory;

		public List<InventoryType> getInventory() {
			if (inventory == null) {
				inventory = new ArrayList<InventoryType>();
			}
			return this.inventory;
		}
	}

	public static class ExternalIds {
		protected List<ExternalIdType> externalId;

		public List<ExternalIdType> getExternalId() {
			if (externalId == null) {
				externalId = new ArrayList<ExternalIdType>();
			}
			return this.externalId;
		}
	}

	public static class Accumulators {
		protected List<AccumulatorType> accumulator;

		public List<AccumulatorType> getAccumulator() {
			if (accumulator == null) {
				accumulator = new ArrayList<AccumulatorType>();
			}
			return this.accumulator;
		}
	}
}
