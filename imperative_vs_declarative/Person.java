package imperative_vs_declarative;

public class Person {

	private final String name;
	private final Gender gender;

	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + getGender() + "]";
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

}
