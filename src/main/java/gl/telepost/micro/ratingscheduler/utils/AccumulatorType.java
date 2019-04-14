package gl.telepost.micro.ratingscheduler.utils;

import java.util.Date;

public class AccumulatorType
{
    protected String accountInternalId;
    protected String accumulatorID;
    protected String serviceInternalId;
    protected String serviceInternalIdResets;
    protected Double amount;
    protected String currencyCode;
    protected Date nextReset;
    protected Integer period;
    protected Integer unitType;
    protected Integer zeroDay;
    protected Integer limit;
    protected String description;

    public String getAccountInternalId() {
        return accountInternalId;
    }

    public void setAccountInternalId(String accountInternalId) {
        this.accountInternalId = accountInternalId;
    }

    public String getAccumulatorID() {
        return accumulatorID;
    }

    public void setAccumulatorID(String accumulatorID) {
        this.accumulatorID = accumulatorID;
    }

    public String getServiceInternalId() {
        return serviceInternalId;
    }

    public void setServiceInternalId(String serviceInternalId) {
        this.serviceInternalId = serviceInternalId;
    }

    public String getServiceInternalIdResets() {
        return serviceInternalIdResets;
    }

    public void setServiceInternalIdResets(String serviceInternalIdResets) {
        this.serviceInternalIdResets = serviceInternalIdResets;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getNextReset() {
        return nextReset;
    }

    public void setNextReset(Date nextReset) {
        this.nextReset = nextReset;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public Integer getZeroDay() {
        return zeroDay;
    }

    public void setZeroDay(Integer zeroDay) {
        this.zeroDay = zeroDay;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
