package com.uottawa.segproject;

/**
 * The ClientAccount class extends Account class. It permits the creation
 * of a client account, which stores information pertaining to the legal name 
 * (first and last), email, account name(email address), password, address, 
 * and credit card of the client. In addition, the class supports some basic 
 * functions such as setting and changing various attributes of a given 
 * client as well as retrieving their information.
 * 
 * @author Ziran Wei (300188723)
 */
public class ClientAccount extends Account {

	/**
	 * Contains the credit card number of a specific client account
	 */
	private long creditCard;

	/**
	 * Default constructor
	 */
	public ClientAccount() {
		super();
	}

	/**
	 * Constructs a specific client with first and last name, email, password
	 * address, and credit card information
	 */
	public ClientAccount(
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			String address, 
			long creditCard) {
		super(firstName, lastName, email, password, address);
		this.creditCard = creditCard;
	}

	/**
	 * This method sets credit card number of a client
	 * 
	 * @param creditCard A new credit card number
	 * @return A string indicating that the credit card number is updated
	 */
	public String setCreditCard(long creditCard) {
		this.creditCard = creditCard;
		return "Credit card changed to: " + this.creditCard;
	}

	/**
	 * This method sets the first name of a client
	 * 
	 * @param firstName A new first name
	 * @return A string indicating that the first name is updated
	 */
	@Override
	public String setFirstName(String firstName) {
		this.firstName = firstName;
		return "First name changed to: " + this.firstName;
	}

	/**
	 * This method sets the last name of a client
	 * 
	 * @param lastName A new last name
	 * @return A string indicating that the last name is updated
	 */
	@Override
	public String setLastName(String lastName) {
		this.lastName = lastName;
		return "Last name changed to: " + this.firstName;
	}

	/**
	 * This method sets the password of a client
	 * 
	 * @param password A new password
	 * @return A string indicating that the password is updated
	 */
	@Override
	public String setPassword(String password) {
		this.password = password;
		return "Password changed to: " + this.password;
	}

	/**
	 * This method sets the address of a client
	 * 
	 * @param address A new address
	 * @return A string indicating that the address is updated
	 */
	@Override
	public String setAddress(String address) {
		this.address = address;
		return "Address changed to: " + this.address;
	}

	/**
	 * This method will retrieve the credit card number of the client
	 * 
	 * @return The credit card number of the client
	 */
	public long getCreditCard() {
		return creditCard;
	}

	/**
	 * This method will retrieve the first name of the client
	 * 
	 * @return The first name of the client
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method will retrieve the last name of the client
	 * 
	 * @return The last name of the client
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method will retrieve the email address of the client
	 * 
	 * @return The email address of the client
	 */
	@Override
	public String getMail() {
		return email;
	}
	
	/**
	 * This method will retrieve the account name of the client
	 * 
	 * @return The email address will represent the account name
	 */
	@Override
	public String getAccountName() {
		return email;
	}
	
	/**
	 * This method will retrieve the password of the client
	 * 
	 * @return The password of the client
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * This method will retrieve the address of the client
	 * 
	 * @return The address of the client
	 */
	@Override
	public String getAddress() {
		return address;
	}

	

}
