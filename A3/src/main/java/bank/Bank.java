//Baischer, Johannes
//Krall, Daniel

package bank;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * A Bank. This class manages customers (<code>Customer</code>) and their
 * accounts (<code>Account</code> and derived classes).
 * 
 * All accounts and all customers managed by this class must have a unique
 * identifier.
 * 
 * Note: There may exist multiple customers that share the same firstname,
 * lastname, and day of birth. Nevertheless, all customers have a unique
 * identifier.
 * 
 * The bank supports two different types of accounts: (i) corporate account,
 * (ii) personal account
 * 
 * (i) A corporate account is allowed to have a negative balance (without
 * limit). Furthermore, a corporate bank account may be owned by multiple
 * customers.
 * 
 * (ii) A personal account is owned by a single customer. Furthermore, they are
 * NOT allowed to have a negative balance.
 * 
 */
public class Bank {
	Map<String, Customer> customers;
	Map<String, Account> accounts;

	public Bank() {
		customers = new TreeMap<String, Customer>();
		accounts = new TreeMap<String, Account>();
	}

	/**
	 * Creates and registers a new <code>Customer</code> object whose attributes
	 * correspond to the given values.
	 * 
	 * @param firstName the customer's first name
	 * @param lastName  the customer's last name
	 * @param birthDay  the customer's birthday
	 * @return the id of the created and registered customer object
	 */
	public String registerCustomer(String firstName, String lastName, Date birthDay) {
		Customer customer = new Customer(firstName, lastName, birthDay);
		customers.put(customer.getID(), customer);

		return customer.getID();
	}

	/**
	 * Returns the collection of all registered customers that share the given first
	 * name and last name and are also born on the same day (i.e., they share the
	 * same date, month, and year of birth).
	 * 
	 * @param firstName a first name
	 * @param lastName  a last name
	 * @param birthDay  a day of birth
	 * @return the (possibly empty) collection;
	 */
	public Collection<String> getCustomers(String firstName, String lastName, Date birthDay) {
		Collection<String> customerIDS = new LinkedList<String>();

		customers.forEach((k,v) -> {
			if((v.getFirstName().equals(firstName))
				&& (v.getLastName().equals(lastName))
				&& (v.getBirthDay().equals(birthDay))){
					customerIDS.add(k);
				}
		});

		return customerIDS;
	}

	/**
	 * removes the given account from the bank
	 * 
	 * @param accountId the id of the account
	 * @return true if an account with the given id existed and was successfully
	 *         removed; otherwise false
	 */
	public boolean removeAccount(String accountId) {
		if((accountId != null) && (accounts.containsKey(accountId))){
			accounts.remove(accountId);
			return true;
		}

		return false;
	}

	/**
	 * creates and registers a new <code>CorporateAccount</code> where the customers
	 * with the given customerIds shall be owners of the account. Note: A corporate
	 * account may have a negative balance. Note: Corporate accounts may be owned by
	 * multiple customers
	 * 
	 * @param customerId the identifiers of already registered customers who will be
	 *                   the owners of the account
	 * @return the unique id of the newly created account as an {@link Optional}; the {@link Optional} is empty if at least one
	 *         of the customers is not registered in the bank
	 */
	public Optional<String> registerCorporateAccount(String... customerId) {
		if(customerId == null)
			return Optional.empty();

		for(String customer : customerId){
			if((customer == null) || (!customers.containsKey(customer)))	//customer not registered
				return Optional.empty();
		}

		Account account = new CorporateAccount(new BigDecimal(0), customerId);
		accounts.put(account.getID(), account);

		return Optional.of(account.getID());
	}

	/**
	 * creates and registers a new <code>PersonalAccount</code> where customer with
	 * the given customerId shall be the owner of the account.
	 * 
	 * Note: A personal account must never have a negative balance.
	 * 
	 * @param customerId the identifier of an already registered customer who will
	 *                   be the owner of the account
	 * @return the unique id of the newly created account as an {@link Optional}; the {@link Optional} is empty if the customer
	 *         with the specified id is not registered in the bank
	 */
	public Optional<String> registerPersonalAccount(String customerId) {
		if((customerId == null) || (!customers.containsKey(customerId)))	//customer not registered
			return Optional.empty();

		Account account = new PersonalAccount(new BigDecimal(0), customerId);
		accounts.put(account.getID(), account);

		return Optional.of(account.getID());
	}

	/**
	 * Returns the balance of the account with the given id
	 * 
	 * @param accountId the id of the account
	 * @return the balance of the account as an {@link Optional}; the {@link Optional} is empty if no account for this id is
	 *         registered
	 */
	public Optional<BigDecimal> getBalance(String accountId) {
		if((accountId == null) || (!accounts.containsKey(accountId)))
			return Optional.empty();

		return Optional.of(accounts.get(accountId).getBalance());
	}

	/**
	 * Deposit operation. Adds the given amount to the account with the specified id
	 * 
	 * @param accountId the id of the account
	 * @param amount    the amount that shall be deposited
	 * @return true iff the amount was successfully deposited; false otherwise
	 */
	public boolean deposit(String accountId, BigDecimal amount) {
		if((accountId == null) || (amount == null))
			return false;

		Account acc = accounts.get(accountId);
		if(acc == null)
			return false;

		acc.deposit(amount);

		return true;
	}

	/**
	 * Widthdraw operation. Substracts the given amount from the account with the
	 * specified id
	 * 
	 * @param accountId the id of the account
	 * @param amount    the amount that shall be widhdrawn
	 * @return true iff the amount was successfully withdrawn; false otherwise
	 */
	public boolean withdraw(String accountId, BigDecimal amount) {
		if((accountId == null) || (amount == null))
			return false;

		Account acc = accounts.get(accountId);

		if(acc == null)
			return false;

		return acc.withdraw(amount);
	}

	/**
	 * Transfer operation. Transfers the given amount between the accounts with the
	 * specified ids
	 * 
	 * @param fromAccountId the id of the account from which the money is transfered
	 * @param toAccountId   the id of the account to which the money is transfered
	 *                      to
	 * @param amount        the amount that shall be transfered
	 * @return true iff the transfer operation was performed successfully; false
	 *         otherwise
	 */
	public boolean transfer(String fromAccountId, String toAccountId, BigDecimal amount) {
		if(!withdraw(fromAccountId, amount))
			return false;

		if(!deposit(toAccountId, amount)){
			//give money back
			deposit(fromAccountId, amount);
			return false;
		}

		return true;
	}

	/**
	 * Returns the collection of accounts that are owned by the customer with the
	 * given id
	 * 
	 * @param customerId the id of the owning customer
	 * @return the (potentially empty) collection of accounts (e.g., a list) as an {@link Optional};
	 *         the {@link Optional} is empty if no customer with the given id is registered
	 */
	public Optional<Collection<String>> getAccounts(String customerId) {
		Collection<String> accountIDs = new LinkedList<String>();

		if((customerId == null) || (customers.get(customerId) == null))
			return Optional.empty();

		//go through all owners for all accounts
		accounts.forEach((k,v) -> {
			for(String owner : v.owner)
				if(owner.equals(customerId))
					accountIDs.add(k);
		});
	
		return Optional.of(accountIDs);
	}

	/**
	 * Returns the total balance of all accounts owned by the customer with the
	 * specified id
	 * 
	 * @param customerId the id of the customer
	 * @return the sum of all accounts owned by the customer as an {@link Optional}; the {@link Optional} is
	 *         empty if no customer with the given id is registered
	 */
	public Optional<BigDecimal> getTotalBalance(String customerId) {
		BigDecimal total = new BigDecimal(0);
		Collection<String> accountIDs;

		//check if customer exists
		if((customerId == null) || (customers.get(customerId) == null))
			return Optional.empty();

		
		//get all accounts for a customer
		Optional<Collection<String>> accIDsOrEmpty = getAccounts(customerId);
		accountIDs = accIDsOrEmpty.orElseGet(null);

		if(accountIDs == null)
			return Optional.empty();


		for(String accID : accountIDs){
			total = total.add(accounts.get(accID).getBalance());
		}
		
		return Optional.of(total);
	}
}
