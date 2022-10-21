package com.uottawa.segproject;

import android.graphics.Bitmap;
import android.os.Build;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * The CookAccount class extends the Account class. It permits the creation
 * of a cook account, which stores information pertaining  to the legal name 
 * (first and last), email, the account name(email address), password, and 
 * address of the cook. Further, the cook can upload a short description of 
 * themselves and a void cheque to their account. The class supports some basic 
 * functions such as setting and changing various attributes about a given cook 
 * as well as retrieving their information.
 * 
 * @author Ziran Wei (300188723)
 */
public class CookAccount extends Account{
	
	/**
	 * Contains a short description of the cook
	 */
	private String description;
	
	/**
	 * Contains the void cheque image as byte array
	 */
	private Bitmap chequeImageToData;
	
	/**
	 * Default constructor
	 */
	public CookAccount() {
		super();
	}
	
	/**
	 * Constructs a specific cook with first and last name, email, password
	 * address, and a short description
	 */
	public CookAccount(String firstName, 
			String lastName, 
			String email, 
			String password, 
			String address,
			String description,
					   Bitmap bp) throws IOException {
		super(firstName, lastName, email, password, address);
		this.description = description;
		chequeImageToData = bp;
	}
	

	
	/**
	 * This method sets a short description of a cook
	 * 
	 * @param description A new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * This method sets the first name of a cook
	 * 
	 * @param firstName A new first name
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This method sets the last name of a cook
	 * 
	 * @param lastName A new last name
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * This method sets the password of a cook
	 * 
	 * @param password A new password
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method sets the address of a cook
	 * 
	 * @param address A new address
	 */
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * This method will retrieve and return the void cheque image
	 * as a byte array
	 *
	 * @return The byte array that represents the void cheque image
	 */
	public Bitmap getChequeImageAsData() {
		return chequeImageToData;
	}

	/**
	 * This method will retrieve the short description of the cook
	 *
	 * @return The the short description of the cook
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method will retrieve the first name of the cook
	 * 
	 * @return The first name of the cook
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method will retrieve the last name of the cook
	 * 
	 * @return The last name of the cook
	 */
	@Override
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method will retrieve the email address of the cook
	 * 
	 * @return The email address of the cook
	 */
	@Override
	public String getMail() {
		return email;
	}
	
	/**
	 * This method will retrieve the account name of the cook
	 * 
	 * @return The email address representing the account name
	 */
	@Override
	public String getAccountName() {
		return email;
	}

	/**
	 * This method will retrieve the password of the cook
	 * 
	 * @return The password of the cook
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	/**
	 * This method will retrieve the address of the cook
	 * 
	 * @return The address of the cook
	 */
	@Override
	public String getAddress() {
		return address;
	}

	

}
