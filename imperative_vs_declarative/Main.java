package imperative_vs_declarative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the differences between imperative and declarative approaches.
 */
public class Main {

	public static void main(String[] args) {
		List<Person> people = List.of(new Person("John", Gender.MALE),
				new Person("Maria", Gender.FEMALE), new Person("Aisha", Gender.FEMALE),
				new Person("Alex", Gender.MALE), new Person("Alice", Gender.FEMALE));

		System.out.println("Imperative approach");

		List<Person> females = new ArrayList<>();
		for (Person person : people) {
			if (Gender.FEMALE.equals(person.getGender())) {
				females.add(person);
			}
		}

		for (Person female : females) {
			System.out.println(female);
		}

		System.out.println("\nDeclarative approach");

		List<Person> females2 = people.stream()
				.filter(person -> Gender.FEMALE.equals(person.getGender()))
				.collect(Collectors.toList());

		females.forEach(System.out::println); // same as .forEach(person -> System.out.println(person))
	}

}
