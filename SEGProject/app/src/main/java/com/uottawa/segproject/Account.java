package com.uottawa.segproject;

/**
 * This class permits the creation of an account containing information, 
 * such as legal name (first and last), email address, account name(email address),
 * password, and address. In addition, the class supports some basic functions 
 * such as setting and changing the various attributes of the account and
 * retrieving information about a given account.
 * 
 * @author Ziran Wei (300188723)
 */
public abstract class Account {

	/**
	 * Contains the first name of the account
	 */
	protected String firstName;

	/**
	 * Contains the last name of the account
	 */
	protected String lastName;

	/**
	 * Contains the email address of the account
	 */
	protected String email;

	/**
	 * Contains the password of the account
	 */
	protected String password;

	/**
	 * Contains the address of the account
	 */
	protected String address;

	/**
	 * Default constructor
	 */
	public Account() {

	}

	/**
	 * Constructs the account with specified first and last name, email, password,
	 * and address
	 */
	public Account(
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	/**
	 * This method sets the first name of the person who created the account
	 */
	public abstract void setFirstName(String firstName);

	/**
	 * This method sets the last name of the person who created the account
	 */
	public abstract void setLastName(String lastName);

	/**
	 * This method sets the password of the account
	 */
	public abstract void setPassword(String password);

	/**
	 * This method sets the address of the person who created the account
	 */
	public abstract void setAddress(String address);

	/**
	 * This method will return the first name of the person who made the account
	 * 
	 * @return First name of the person who created the account
	 */
	public abstract String getFirstName();

	/**
	 * This method will return the last name of the person who made the account
	 * 
	 * @return Last name of the person who created the account
	 */
	public abstract String getLastName();

	/**
	 * This method will return the email address of the person who created the
	 * account
	 * 
	 * @return Email address of the person who created the account
	 */
	public abstract String getMail();
	
	/**
	 * This will method will return the account name of the account,
	 * which is the email
	 * 
	 * @return The email address will represent the account name
	 */
	public abstract String getAccountName();
	
	/**
	 * This method will return the password of the account
	 * 
	 * @return Password of the account
	 */
	public abstract String getPassword();

	/**
	 * This method will return the address of the person who created the account
	 * 
	 * @return Address of the person who created the account
	 */
	public abstract String getAddress();
}
