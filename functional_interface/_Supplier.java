package functional_interface;

import java.util.function.Supplier;

/**
 * This is a functional interface and can therefore be used as the assignment
 * target for a lambda expression or method reference.
 */
public class _Supplier {

	public static void main(String[] args) {
		System.out.println(getJdbcConnectionUrlSupplier.get());
	}

	/**
	 * Represents a supplier of results.
	 * 
	 * There is no requirement that a new or distinct result be returned each time
	 * the supplier is invoked.
	 * 
	 * This is a functional interface whose functional method is get().
	 */
	private static Supplier<String> getJdbcConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

	/**
	 * The non Functional equivalent of .
	 */
	private static String getJdbcConnectionUrl() {
		return "jdbc://localhost:5432/users";
	}

}
