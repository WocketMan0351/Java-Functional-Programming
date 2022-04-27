package combinator;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is the non combinator pattern equivalent of
 * CustomerRegistrationValidator and only returns true or false, without
 * specifying what was not validated.
 */
public class CustomerValidatorService {

	private boolean isEmailValid(String email) {
		return email.contains("@");
	}

	private boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("+0");
	}

	private boolean isAdult(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears() > 18;
	}

	public boolean isValid(Customer customer) {
		return isEmailValid(customer.getEmail()) && isPhoneNumberValid(customer.getPhoneNumer())
				&& isAdult(customer.getDob());
	}

}
