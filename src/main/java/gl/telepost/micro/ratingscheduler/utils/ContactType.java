package gl.telepost.micro.ratingscheduler.utils;

import java.util.ArrayList;
import java.util.List;

public class ContactType {
	protected String contactId;
	protected String firstName;
	protected String lastName;
	protected String companyName;
	protected String email;
	protected String departmentName;
	protected String glnCode;
	protected String mainPhone;
	protected ContactType.PhoneNumbers phoneNumbers;

	public static class PhoneNumbers {
		protected List<ContactPhoneNumberType> phoneNumber;

		public List<ContactPhoneNumberType> getPhoneNumber() {
			if (phoneNumber == null) {
				phoneNumber = new ArrayList<ContactPhoneNumberType>();
			}
			return this.phoneNumber;
		}
	}
}
