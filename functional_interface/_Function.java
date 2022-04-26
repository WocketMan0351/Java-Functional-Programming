package functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * This is a functional interface and can therefore be used as the assignment
 * target for a lambda expression or method reference.
 */
public class _Function {

	public static void main(String[] args) {
		// Function takes 1 argument and returns 1 result
		int number = incrementBy1Function.apply(1);
		System.out.println(number + "  <-- output from incrementByOneFunction.apply(1)");

		int number2 = multiplyBy10Function.apply(incrementBy1Function.apply(1));
		System.out.println(number2 + " <-- output from multiplyByTenFunction.apply(incrementByOneFunction.apply(1))");

		int number3 = incrementBy1AndThenMultiplyBy10Function.apply(1);
		System.out.println(number3 + " <-- output from incrementBy1AndThenMultiplyBy10.apply(1)");

		// BiFunction takes 2 arguments and returns 1 result
		int number4 = incrementBy1AndMultiplyBiFunction.apply(1, 10);
		System.out.println(number4 + " <-- output from incrementBy1AndMultiplyBiFunction.apply(1, 10)");
	}

	/**
	 * Represents a function that accepts one argument and produces a result. This
	 * is a functional interface whose functional method is apply(Object).
	 * 
	 * T - the type of the input to the function
	 * 
	 * R - the type of the output of the function
	 * 
	 */
	private static Function<Integer, Integer> incrementBy1Function = number -> number + 1;

	private static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	/**
	 * Returns a composed function that first applies this function to its input,
	 * and then applies the after function to the result.
	 * 
	 * Returns a composed function that first applies this function to its input,
	 * and then applies the after function to the result.
	 * 
	 * T - the type of the input to the function
	 * 
	 * R - the type of the output of the function
	 * 
	 */
	private static Function<Integer, Integer> incrementBy1AndThenMultiplyBy10Function = incrementBy1Function
			.andThen(multiplyBy10Function);

	/**
	 * Represents a function that accepts two arguments and produces a result. This
	 * is the two-arity specialization of Function. This is a functional interface
	 * whose functional method is apply(Object, Object).
	 * 
	 * T - the type of the first argument to the function
	 * 
	 * U - the type of the second argument to the function
	 * 
	 * R - the type of the output of the function
	 * 
	 */
	private static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiplyBiFunction = (numberToIncrementByOne,
			numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

	/**
	 * NON FUNCTIONAL EQUIVALENT REFERENCES
	 */

	/**
	 * The non functional equivalent of incrementByOneFunction.
	 */
	private static int incrementByOne(int number) {
		return number + 1;
	}

	/**
	 * The non functional equivalent of incrementBy1AndMultiplyBiFunction.
	 */
	private static int incrementBy1AndMultiplyBy10(int number, int numberToMultiplyBy) {
		return (number + 1) * numberToMultiplyBy;
	}

}
