package com.flipkart.business;

import org.apache.log4j.Logger;

public class AuthorCredentialSystemBusiness
{
	public static Logger logger = Logger.getLogger(AuthorCredentialSystemBusiness.class);
	
	public boolean approveStudent() {
		
		System.out.println("Approve student function, AuthorCredentialSystemBusiness class");
		return true;
		
	}
	public boolean registerAdmin() {
		
		System.out.println("Register Admin function, AuthorCredentialSystemBusiness class");
		return true;
	}
	public boolean registerProfessor() {
		
		System.out.println("Register professor function, AuthorCredentialSystemBusiness class");
		return true;
	}

}
