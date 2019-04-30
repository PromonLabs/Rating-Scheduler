package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.utils.*;
//import jdk.management.resource.ResourceType;

import java.util.ArrayList;
import java.util.List;

public class GetServiceInformationV3ResponseType {
	protected StatusType status;
	protected ServiceType service;
	protected AddressType address;
	protected PricePlanType priceplan;
	protected TariffType tariff;
	protected RecurringFeeType recurringFee;
	protected NonRecurringFeeType nonRecurringFee;
	protected BalanceType balance;
	// protected ResourceType resource;
	protected GetServiceInformationV3ResponseType.Offers offers;
	protected GetServiceInformationV3ResponseType.Balances balances;
	protected Boolean serviceBarredByCreditLimit;

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public AddressType getAddress() {
		return address;
	}

	public void setAddress(AddressType address) {
		this.address = address;
	}

	public PricePlanType getPriceplan() {
		return priceplan;
	}

	public void setPriceplan(PricePlanType priceplan) {
		this.priceplan = priceplan;
	}

	public TariffType getTariff() {
		return tariff;
	}

	public void setTariff(TariffType tariff) {
		this.tariff = tariff;
	}

	public RecurringFeeType getRecurringFee() {
		return recurringFee;
	}

	public void setRecurringFee(RecurringFeeType recurringFee) {
		this.recurringFee = recurringFee;
	}

	public NonRecurringFeeType getNonRecurringFee() {
		return nonRecurringFee;
	}

	public void setNonRecurringFee(NonRecurringFeeType nonRecurringFee) {
		this.nonRecurringFee = nonRecurringFee;
	}

	public BalanceType getBalance() {
		return balance;
	}

	public void setBalance(BalanceType balance) {
		this.balance = balance;
	}

	// public ResourceType getResource() {
	// return resource;
	// }
	//
	// public void setResource(ResourceType resource) {
	// this.resource = resource;
	// }

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}

	public Boolean getServiceBarredByCreditLimit() {
		return serviceBarredByCreditLimit;
	}

	public void setServiceBarredByCreditLimit(Boolean serviceBarredByCreditLimit) {
		this.serviceBarredByCreditLimit = serviceBarredByCreditLimit;
	}

	public static class Offers {
		protected List<OfferType> offerList;

		public List<OfferType> getOfferList() {
			if (offerList == null) {
				offerList = new ArrayList<OfferType>();
			}
			return this.offerList;
		}
	}

	public static class Balances {
		protected List<BalanceType> balanceList;

		public List<BalanceType> getBalanceList() {
			if (balanceList == null) {
				balanceList = new ArrayList<BalanceType>();
			}
			return this.balanceList;
		}
	}
}
