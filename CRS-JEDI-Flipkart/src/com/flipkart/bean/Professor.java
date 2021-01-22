package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Professor extends User {
	// Department of the professor
	private String department;
	
	// Parameterized Constructor
	public Professor(String userId, String emailId, String password, String name, long mobile, Role role, Gender gender,
			String department) {
		super(userId, emailId, password, name, mobile, role, gender);
		this.department = department;
	}
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
		
}
