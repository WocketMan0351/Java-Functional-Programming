package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		String upperCasedName = upperCaseName.apply("bella");
		System.out.println(upperCasedName);

		String lowerCasedName = lowerCasename.apply("BELLA", 2);
		System.out.println(lowerCasedName);
	}

	/**
	 * single return statement
	 */
	private static Function<String, String> upperCaseName = name -> name.toUpperCase();

	/**
	 * BiFunction with multiple return statement
	 */
	private static BiFunction<String, Integer, String> lowerCasename = (name, age) -> {
		if (name.isBlank()) {
			throw new IllegalArgumentException();
		}
		return name.toLowerCase() + " " + age;
	};

}
