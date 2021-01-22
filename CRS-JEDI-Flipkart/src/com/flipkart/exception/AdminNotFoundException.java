/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ABHI SHREE JAIN
 *
 */
public class AdminNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	String adminUsername;
	
	// Constructor to initialize adminUsername  
	public AdminNotFoundException(String adminUsername) {
		super();
		this.adminUsername = adminUsername;
	}

	/**
	 * @return the studnetUsername
	 */
	public String getUsername() {
		return adminUsername;
	}
	
}