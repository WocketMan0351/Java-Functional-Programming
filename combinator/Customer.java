package combinator;

import java.time.LocalDate;

public class Customer {

	private final String name;
	private final String email;
	private final String phoneNumer;
	private final LocalDate dob;

	public Customer(String name, String email, String phoneNumer, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.phoneNumer = phoneNumer;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public LocalDate getDob() {
		return dob;
	}

}
