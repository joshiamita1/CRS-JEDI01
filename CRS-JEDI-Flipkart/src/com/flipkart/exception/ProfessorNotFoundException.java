/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ABHI SHREE JAIN
 *
 */
public class ProfessorNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	String professorUsername;
	
	// Constructor to initialize professorUsername  
	public ProfessorNotFoundException(String professorUsername) {
		super();
		this.professorUsername = professorUsername;
	}

	/**
	 * @return the professorUsername
	 */
	public String getUsername() {
		return professorUsername;
	}
	
}
