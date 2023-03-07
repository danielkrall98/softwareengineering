package bank;

import java.math.BigDecimal;

/**
 * A bank account. This is an abstract base class for
 * <code>PersonalAccount</code> and <code>CorporateAccount</code>.
 * 
 */
public abstract class Account {
	private static int runningID = 1;

	protected BigDecimal balance;
	protected String[] owner;
	private String id;

	protected Account(BigDecimal balance, String... owner){
		this.balance = balance;
        this.owner = owner;

		id = "";
		for(String o : this.owner){
			id += o + "&";
		}
		id += runningID++;
	}

	/**
	 * Withdraws the given amount from the account's balance.
	 * 
	 * @param amount the amount to withdraw
	 * @return boolean true iff the withdraw operation was successful
	 */
	protected abstract boolean withdraw(BigDecimal amount);

	/**
	 * Deposits the given amount to the account's balance.
	 * 
	 * @param amount the amount to deposit
	 * @return boolean true iff the deposit operation was successful
	 */
	public boolean deposit(BigDecimal amount){
		balance = balance.add(amount);
		return true;
	}

	/**
	 * @return the balance of the account
	 */
	public BigDecimal getBalance(){
		return balance;
	}

	/**
	 * @return the unique account id
	 */
	public String getID(){
		return id;
	}
	
}
