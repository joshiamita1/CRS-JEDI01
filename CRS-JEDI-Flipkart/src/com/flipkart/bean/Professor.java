package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Professor extends User {
	// Department of the professor
	private Department department;
	
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
