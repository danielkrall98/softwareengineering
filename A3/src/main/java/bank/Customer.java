package bank;

import java.util.Date;

/**
 * A customer. Customers are identified by a unique id.
 *
 */
public class Customer {
	private static int runningID = 1;

	private String id;
	private String firstName, lastName;
	private Date birthDay;

	public Customer(String firstName, String lastName, Date birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;

		this.id = 
			firstName + "|" +
			lastName  + "|" +
			birthDay  + "|" +
			runningID++;
	}

	/**
	 * @return the first name of this customer
	 */
	protected String getFirstName() {
		return firstName;
	}

	/**
	 * @return the last name of this customer
	 */
	protected String getLastName() {
		return lastName;
	}

	/**
	 * @return the birthday of this customer
	 */
	protected Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @return the unique customer id
	 */
	protected String getID() {
		return id;
	}
}
