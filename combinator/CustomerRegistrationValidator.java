package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/**
 * A demonstration of the combinator pattern. A combinator pattern is a function
 * that can take other functions as arguments and return new functions. This
 * simplifies the logic and will either return SUCCESS for a successful
 * validation or indicate the specific reason for not being validated.
 */
public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

	public static CustomerRegistrationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS
				: ValidationResult.EMAIL_NOT_VALID;
	}

	public static CustomerRegistrationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumer().startsWith("+0") ? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NUMBER_NOT_VALID;
	}

	public static CustomerRegistrationValidator isAnAdult() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18
				? ValidationResult.SUCCESS
				: ValidationResult.IS_NOT_AN_ADULT;
	}

	default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(result.SUCCESS) ? other.apply(customer) : result;
		};
	}

}
