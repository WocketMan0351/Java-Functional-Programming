package combinator;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer(
				"Alyssa",
				"alyssagmail.com", // email not valid
				"+08018426512",
				LocalDate.of(1998, 05, 23));

		// CustomerValidatorService simply returns true or false
		System.out.println("Testing CustomerValidatorService (not combinator pattern)...");
		System.out.println(new CustomerValidatorService().isValid(customer));

		/**
		 * CustomerRegistrationService returns either SUCCESS, EMAIL_NOT_VALID,
		 * PHONE_NUMBER_NOT_VALID, OR IS_NOT_AN_ADULT. The combinator pattern
		 * implemented in CustomerRegistrationService simplifies this logic.
		 * 
		 * Lazy implementation because apply() is invoked at the end.
		 */
		System.out.println(
				"\nTesting CustomerRegistrationService (an interface with the combinator pattern)...");

		ValidationResult result = CustomerRegistrationValidator
				.isEmailValid()
				.and(CustomerRegistrationValidator.isPhoneNumberValid())
				.and(CustomerRegistrationValidator.isAnAdult())
				.apply(customer); // none of this is run until we invoke apply(customer)

		System.out.println(result);

		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
	}

}
