package optionals;

import java.util.Optional;

/**
 * Optionals help us be safe with null values.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Demonstrating ofNullable() with a null object...");
		Object value = Optional.ofNullable(null)
				.orElseGet(() -> "default value"); // do if the above object is null
		System.out.println(value);

		System.out.println("\nDemonstrating ofNullable() with a non null object...");
		Object value2 = Optional.ofNullable("non null object")
				.orElseGet(() -> "default value"); // do if the above object is null
		System.out.println(value2);

		System.out.println("\nDemonstrating ifPresent()...");
		Optional.ofNullable("bella@hotmail.com")
				// only continue if the above object is non null
				.ifPresent(email -> System.out.println("sending email to " + email));

		System.out.println("\nDemonstrating orElseThrow()...");
		Object valueX = Optional.ofNullable(null)
				// do if the above object is null
				.orElseThrow(() -> new IllegalStateException()); // takes a supplier
		System.out.println(valueX);
	}

}
