package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;

public class AuthorCredentialSystemBusiness
{
	public static Logger logger = Logger.getLogger(AuthorCredentialSystemBusiness.class);
	
	
	public void  approveStudent(Student studentobj)
	{
		try
		{
	        if(studentobj.getUserId()=="1")	
		    logger.info("Approve student function, AuthorCredentialSystemBusiness class");
		}
		
		catch(Exception e)
		{
			logger.info("invalid entry");
		}
	}
//	public boolean registerAdmin() {
//		
//		logger.info("Register Admin function, AuthorCredentialSystemBusiness class");
//		return true;
//	}
//	public boolean registerProfessor() {
//		
//		logger.info("Register professor function, AuthorCredentialSystemBusiness class");
//		return true;
//	}


	
	
}
