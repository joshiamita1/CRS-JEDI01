/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ABHI SHREE JAIN
 *
 */
public class StudentNotFoundException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	
	String studentUsername;
	
	// Constructor to initialize username  
	public StudentNotFoundException(String studentUsername) {
		super();
		this.studentUsername = studentUsername;
	}

	/**
	 * @return the studnetUsername
	 */
	public String getUsername() {
		return studentUsername;
	}
	

}
