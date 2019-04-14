package gl.telepost.micro.ratingscheduler.utils;

import java.util.ArrayList;
import java.util.List;

public class PricePlanType
{
    protected PricePlanType.Tariffs tariffs;
    protected PricePlanType.RecurringFees recurringFees;
    protected PricePlanType.NonRecurringFees nonRecurringFees;

    public static class Tariffs
    {
        protected List<TariffType> tariff;

        public List<TariffType> getTariff() {
            if (tariff == null) {
                tariff = new ArrayList<TariffType>();
            }
            return this.tariff;
        }
    }

    public static class RecurringFees
    {
        protected List<RecurringFeeType> recurringFee;

        public List<RecurringFeeType> getRecurringFee() {
            if (recurringFee == null) {
                recurringFee = new ArrayList<RecurringFeeType>();
            }
            return this.recurringFee;
        }
    }

    public static class NonRecurringFees
    {
        protected List<NonRecurringFeeType> nonRecurringFee;

        public List<NonRecurringFeeType> getNonRecurringFee() {
            if (nonRecurringFee == null) {
                nonRecurringFee = new ArrayList<NonRecurringFeeType>();
            }
            return this.nonRecurringFee;
        }
    }
}
