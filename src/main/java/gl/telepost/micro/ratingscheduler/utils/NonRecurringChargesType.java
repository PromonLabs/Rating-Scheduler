package gl.telepost.micro.ratingscheduler.utils;

import java.util.ArrayList;
import java.util.List;

public class NonRecurringChargesType {
	protected List<NonRecurringChargeType> nonRecurringCharge;

	public List<NonRecurringChargeType> getNonRecurringCharge() {
		if (nonRecurringCharge == null) {
			nonRecurringCharge = new ArrayList<NonRecurringChargeType>();
		}
		return this.nonRecurringCharge;
	}
}
