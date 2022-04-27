package callbacks;

import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		// callback using a Consumer
		test("Cody", null,
				acceptedValue -> System.out.println("No last name provided for " + acceptedValue));

		System.out.println();

		// callback using a Runnable
		test2("Cody", null, () -> System.out.println("No last name provided"));
	}

	private static void test(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			callback.accept(firstName);
		}
	}

	/**
	 * Using a Runnable instead of a Consumer for the callback.
	 */
	private static void test2(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			callback.run();
		}
	}

}
