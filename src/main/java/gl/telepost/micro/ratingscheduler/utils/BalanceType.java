package gl.telepost.micro.ratingscheduler.utils;

import java.util.Date;

public class BalanceType
{
    protected Integer balanceId;
    protected Long balanceInstanceId;
    protected Integer accountId;
    protected Integer serviceId;
    protected Short serviceIdResets;
    protected String balanceCategory;
    protected String unit;
    protected Short unitType;
    protected Double value;
    protected String description;
    protected String displayValue;
    protected String paymentType;
    protected Date expirationDate;
    protected Double availableBalance;
    protected String balanceStatus;
    protected String currencyCode;
    protected Double totalBalance;
    protected String limitType;
    protected Double maxLimit;
    protected String lastTransactionReference;

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public Long getBalanceInstanceId() {
        return balanceInstanceId;
    }

    public void setBalanceInstanceId(Long balanceInstanceId) {
        this.balanceInstanceId = balanceInstanceId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Short getServiceIdResets() {
        return serviceIdResets;
    }

    public void setServiceIdResets(Short serviceIdResets) {
        this.serviceIdResets = serviceIdResets;
    }

    public String getBalanceCategory() {
        return balanceCategory;
    }

    public void setBalanceCategory(String balanceCategory) {
        this.balanceCategory = balanceCategory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Short getUnitType() {
        return unitType;
    }

    public void setUnitType(Short unitType) {
        this.unitType = unitType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBalanceStatus() {
        return balanceStatus;
    }

    public void setBalanceStatus(String balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public Double getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getLastTransactionReference() {
        return lastTransactionReference;
    }

    public void setLastTransactionReference(String lastTransactionReference) {
        this.lastTransactionReference = lastTransactionReference;
    }
}
