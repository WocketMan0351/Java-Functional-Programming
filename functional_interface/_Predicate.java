package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * This is a functional interface and can therefore be used as the assignment
 * target for a lambda expression or method reference.
 */
public class _Predicate {

	public static void main(String[] args) {
		System.out.println("Predicate:");
		System.out.println(isPhoneNumberValidPredicate.test("8018426512")); // true
		System.out.println(isPhoneNumberValidPredicate.test("00012348888") + "\n"); // false

		System.out.println("BiPredicate:");
		System.out.println(phoneNumberContains.test("8018426512", "8") + "\n");

		System.out.println("inclusive .or()");
		System.out.println(isPhoneNumberValidPredicate.or(phoneNumberContains3).test("8018426512") + "\n");

		System.out.println(".and()");
		System.out.println(isPhoneNumberValidPredicate.and(phoneNumberContains3).test("8013336512"));
	}

	/**
	 * Represents a predicate (boolean-valued function) of one argument. This is a
	 * functional interface whose functional method is test(Object).
	 * 
	 * T - the type of the input to the predicate
	 */
	private static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("801")
			&& phoneNumber.length() == 10;

	/**
	 * Represents a predicate (boolean-valued function) of one argument. This is a
	 * functional interface whose functional method is test(Object).
	 * 
	 * T - the type of the input to the predicate
	 */
	private static Predicate<String> phoneNumberContains3 = phoneNumber -> phoneNumber.contains("3");

	/**
	 * Represents a predicate (boolean-valued function) of two arguments. This is
	 * the two-arity specialization of Predicate. This is a functional interface
	 * whose functional method is test(Object, Object).
	 * 
	 * T - the type of the first argument to the predicate
	 * 
	 * U - the type of the second argument the predicate
	 */
	private static BiPredicate<String, String> phoneNumberContains = (phoneNumber, containsNumber) -> phoneNumber
			.contains(containsNumber);

	/**
	 * The non Functional equivalent of isPhoneNumberValidPredicate.
	 */
	private static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("801") && phoneNumber.length() == 10;
	}

}
