package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User {
	// Branch of the student
	private String branch;
	
	// Scholarship is provided or not
	boolean hasScholarship;
	
	// Student is Approved;
	boolean isApproved;
	
	// Amount Payable
	double amountPayable;
	
	// Parameterized Constructor
		public Student(String userId, String emailId, String password, String name, long mobile, Role role, Gender gender,
				String branch, boolean hasScholarship, boolean isApproved) {
		super(userId, emailId, password, name, mobile, role, gender);
		this.branch = branch;
		this.hasScholarship = hasScholarship;
		this.isApproved = isApproved;
	}

	
	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}


	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}


	/**
	 * @return the hasScholarship
	 */
	public boolean isHasScholarship() {
		return hasScholarship;
	}

	/**
	 * @param hasScholarship the hasScholarship to set
	 */
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}
		
}
