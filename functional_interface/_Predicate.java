package functional_interface;

import java.util.function.Predicate;

/**
 * This is a functional interface and can therefore be used as the assignment
 * target for a lambda expression or method reference.
 */
public class _Predicate {

	public static void main(String[] args) {
		System.out.println(isPhoneNumberValidPredicate.test("8018426512")); // true
		System.out.println(isPhoneNumberValidPredicate.test("9992224444")); // false
	}

	/**
	 * Represents a predicate (boolean-valued function) of one argument. This is a
	 * functional interface whose functional method is test(Object).
	 * 
	 * T - the type of the input to the predicate
	 * 
	 */
	private static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("801")
			&& phoneNumber.length() == 10;

	/**
	 * The non-predicate equivalent of isPhoneNumberValidPredicate.
	 */
	private static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("801") && phoneNumber.length() == 10;
	}

}
