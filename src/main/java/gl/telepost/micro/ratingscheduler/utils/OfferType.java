package gl.telepost.micro.ratingscheduler.utils;

import gl.telepost.micro.ratingscheduler.db.models.InventoryType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferType
{
    protected String name;
    protected Integer categoryId;
    protected String description;
    protected Integer offerId;
    protected Long offerInstanceId;
    protected Integer totalUnits;
    protected String languageCode;
    protected Double totalNonRecurringChargeAmount;
    protected Double totalRecurringChargeAmount;
    protected Short currencyCode;
    protected String serviceId;
    protected String accountId;
    protected Short serviceIdResets;
    protected OfferType.NonRecurringCharges nonRecurringCharges;
    protected OfferType.RecurringCharges recurringCharges;
    protected InventoryType inventory;
    protected ExternalIdType externalId;
    protected OfferType.FlexUsage flexUsage;
    protected ExtendedDataType extendedData;
    protected String operation;
    protected InventoriesType inventories;
    protected Date offerActiveDate;
    protected Date offerInactiveDate;

    public static class NonRecurringCharges
    {
        protected List<NonRecurringChargeType> nonRecurringCharge;

        public List<NonRecurringChargeType> getNonRecurringCharge() {
            if (nonRecurringCharge == null) {
                nonRecurringCharge = new ArrayList<NonRecurringChargeType>();
            }
            return this.nonRecurringCharge;
        }
    }

    public static class RecurringCharges
    {
        protected List<RecurringChargeType> recurringCharge;

        public List<RecurringChargeType> getRecurringCharge() {
            if (recurringCharge == null) {
                recurringCharge = new ArrayList<RecurringChargeType>();
            }
            return this.recurringCharge;
        }
    }

    public static class FlexUsage
    {
        protected Double maxConsumption;

        public Double getMaxConsumption() {
            return maxConsumption;
        }

        public void setMaxConsumption(Double maxConsumption) {
            this.maxConsumption = maxConsumption;
        }
    }
}
