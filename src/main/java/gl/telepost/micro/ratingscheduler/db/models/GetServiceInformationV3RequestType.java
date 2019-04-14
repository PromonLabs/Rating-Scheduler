package gl.telepost.micro.ratingscheduler.db.models;

import gl.telepost.micro.ratingscheduler.utils.ServiceType;

public class GetServiceInformationV3RequestType
{
    protected ServiceType service;
    protected Boolean onlyCurrentData;
    protected Boolean externalIds;
    protected Boolean balances;
    protected Boolean offers;
    protected Boolean rCs;
    protected Boolean nrCs;
    protected Boolean addresses;
    protected Boolean accumulators;
    protected Boolean consumptionControl;

    public ServiceType getService() {
        return service;
    }

    public void setService(ServiceType service) {
        this.service = service;
    }

    public Boolean getOnlyCurrentData() {
        return onlyCurrentData;
    }

    public void setOnlyCurrentData(Boolean onlyCurrentData) {
        this.onlyCurrentData = onlyCurrentData;
    }

    public Boolean getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(Boolean externalIds) {
        this.externalIds = externalIds;
    }

    public Boolean getBalances() {
        return balances;
    }

    public void setBalances(Boolean balances) {
        this.balances = balances;
    }

    public Boolean getOffers() {
        return offers;
    }

    public void setOffers(Boolean offers) {
        this.offers = offers;
    }

    public Boolean getrCs() {
        return rCs;
    }

    public void setrCs(Boolean rCs) {
        this.rCs = rCs;
    }

    public Boolean getNrCs() {
        return nrCs;
    }

    public void setNrCs(Boolean nrCs) {
        this.nrCs = nrCs;
    }

    public Boolean getAddresses() {
        return addresses;
    }

    public void setAddresses(Boolean addresses) {
        this.addresses = addresses;
    }

    public Boolean getAccumulators() {
        return accumulators;
    }

    public void setAccumulators(Boolean accumulators) {
        this.accumulators = accumulators;
    }

    public Boolean getConsumptionControl() {
        return consumptionControl;
    }

    public void setConsumptionControl(Boolean consumptionControl) {
        this.consumptionControl = consumptionControl;
    }
}
