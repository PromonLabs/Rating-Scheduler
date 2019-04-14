package gl.telepost.micro.ratingscheduler.utils;

import java.util.Date;

public class RecurringChargeType
{
    protected Integer typeId;
    protected Short chargeCount;
    protected Short frequency;
    protected Date chargeDate;
    protected Date activeDate;
    protected Date inactiveDate;
    protected Long rcTermInstanceId;
    protected Double overrideRate;
    protected Integer unit;
    protected String unitType;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Short getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(Short chargeCount) {
        this.chargeCount = chargeCount;
    }

    public Short getFrequency() {
        return frequency;
    }

    public void setFrequency(Short frequency) {
        this.frequency = frequency;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public Long getRcTermInstanceId() {
        return rcTermInstanceId;
    }

    public void setRcTermInstanceId(Long rcTermInstanceId) {
        this.rcTermInstanceId = rcTermInstanceId;
    }

    public Double getOverrideRate() {
        return overrideRate;
    }

    public void setOverrideRate(Double overrideRate) {
        this.overrideRate = overrideRate;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
