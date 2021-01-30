package com.flipkart.validation;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.exception.InvalidLoginException;
import com.flipkart.exception.UserNotFoundException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.constant.Department;
import com.flipkart.constant.Role;

public class Validate {

	public void validateAdmin(User user, String password) {
		AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
		if(authenticateBusinessObject.registerAdmin(user, password)) {
			logger.info("Registration Success");
		} else {
			logger.info("Please Register Again!\nRegistration Failed\n");
		}
	}
	
	public void validateProfessor(User user, String password, Department department) {
		AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
		if(authenticateBusinessObject.registerProfessor(user, password, department)) {
			logger.info("Registration Success.");
		} else {
			logger.info("Please Register Again!\nRegistration Failed\n");
		}
	}
	
	
}
