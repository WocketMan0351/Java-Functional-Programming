package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * This is a functional interface and can therefore be used as the assignment
 * target for a lambda expression or method reference.
 *
 */
public class _Consumer {

	public static void main(String[] args) {
		Customer customer = new Customer("Bella", "800-123-4444");

		// Consumer Functional interface
		greetCustomerConsumer.accept(customer);

		// BiConsume Functional interface
		greetCustomerBiConsumer.accept(customer, false);
	}

	/**
	 * Represents an operation that accepts a single input argument and returns no
	 * result. Unlike most other functional interfaces, Consumer is expected to
	 * operate via side-effects. This is a functional interface whose functional
	 * method is accept(Object). Consumers are a void method.
	 * 
	 * T - the type of the input to the operation.
	 */
	private static Consumer<Customer> greetCustomerConsumer = customer -> System.out
			.println(
					"Hello " + customer.getCustomerName() + ", thanks for registering phone number "
							+ customer.getCustomerPhoneNumber() + ".");

	/**
	 * Represents an operation that accepts two input arguments and returns no
	 * result. This is the two-arity specialization of Consumer. Unlike most other
	 * functional interfaces, BiConsumer is expected to operate via side-effects.
	 * This is a functional interface whose functional method is accept(Object,
	 * Object).
	 * 
	 * T - the type of the first argument to the operation
	 * 
	 * U - the type of the second argument to the operation
	 */
	private static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer,
			showPhoneNumber) -> System.out
					.println("Hello " + customer.getCustomerName()
							+ ", thanks for registering phone number "
							+ (showPhoneNumber ? customer.getCustomerPhoneNumber() : "***-***-****")
							+ ".");

	/**
	 * The non Functional equivalent of the Consumer interface.
	 */
	private static void greetCustomerConsumer(Customer customer) {
		System.out.println(
				"Hello " + customer.getCustomerName() + ", thanks for registering phone number "
						+ customer.getCustomerPhoneNumber() + ".");
	}

	/**
	 * The non Functional equivalent of the BiConsumer interface.
	 */
	private static void greetCustomerBiConsumer(Customer customer, boolean showPhoneNumber) {
		System.out.println("Hello " + customer.getCustomerName()
				+ ", thanks for registering phone number "
				+ (showPhoneNumber ? customer.getCustomerPhoneNumber() : "***-***-****") + ".");
	}

}
