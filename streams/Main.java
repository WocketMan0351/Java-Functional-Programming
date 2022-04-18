package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A demonstration on how Java Streams allow us to work with Collections in a
 * declarative manner. A stream is a sequence of elements from a source -> the
 * source being a Collection (List<Person>) in these examples.
 */
public class Main {

	public static void main(String[] args) {
		List<Person> people = getPeople();

		// Filter
		System.out.println("*** Filter ***");
		List<Person> females = people.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE)) // if condition is true
				.collect(Collectors.toList()); // we collect the results back into a list

		females.forEach(System.out::println); // females.forEach(female -> System.out.println(female))
		System.out.println();

		// Sort
		System.out.println("*** Sort ***");
		List<Person> sorted = people.stream()
				.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
				// refers to getAge() for each Person in people and sorts people by age first
				// then refers to getName() for each Person in people and sorts alphabetically
				// after age
				.collect(Collectors.toList());

		sorted.forEach(System.out::println); // sorted.forEach(person -> System.out.println(person))
		System.out.println();

		// All Match
		System.out.println("*** All Match ***");
		boolean allMatch = people.stream()
				.allMatch(person -> person.getAge() > 6); // all Persons in people are older than 6

		System.out.println(allMatch);
		System.out.println();

		// Any Match
		System.out.println("*** Any Match ***");
		boolean anyMatch = people.stream()
				.anyMatch(person -> person.getAge() >= 18); // there is at least one Person who is 18 years old

		System.out.println(anyMatch);
		System.out.println();

		// None Match
		System.out.println("*** None Match ***");
		boolean noneMatch = people.stream()
				.noneMatch(person -> person.getName().equals("Satoshi")); // there is no Person named Satoshi

		System.out.println(noneMatch);
		System.out.println();

		// Max
		System.out.println("*** Max ***");
		people.stream() // returns an optional because it might not find the max value
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println); // if a value is present, it will print the (non null) optional

		System.out.println();

		// Min
		System.out.println("*** Min ***");
		people.stream()
				.min(Comparator.comparing(Person::getAge))
				.ifPresent(System.out::println); // if a value is present, it will print the (non null) optional

		System.out.println();

		// Group
		System.out.println("*** Group ***");
		Map<Gender, List<Person>> groupByGender = people.stream()
				.collect(Collectors.groupingBy(Person::getGender));

		groupByGender.forEach((gender, peopleList) -> {
			System.out.println(gender);
			peopleList.forEach(System.out::println);
		});
		System.out.println();
	}

	private static List<Person> getPeople() {
		return List.of(
				new Person("Zelda Brown", 20, Gender.FEMALE),
				new Person("Antonio", 20, Gender.MALE),
				new Person("Alina Smith", 33, Gender.FEMALE),
				new Person("Helen White", 57, Gender.FEMALE),
				new Person("Alex Boz", 14, Gender.MALE),
				new Person("Jamie Goa", 99, Gender.MALE),
				new Person("Anna Cook", 7, Gender.FEMALE));
	}

}
