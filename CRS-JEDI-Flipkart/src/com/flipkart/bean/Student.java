package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User {
	// Branch of the student
	private Department branch;
	
	// Scholarship is provided or not
	boolean hasScholarship;
	
	// Student is Approved;
	boolean isApproved;
	
	// Amount Payable
	int amountPayable;

	/**
	 * @return the branch
	 */
	public Department getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Department branch) {
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
	 * @return the amountPayable
	 */
	public int getAmountPayable() {
		return amountPayable;
	}

	/**
	 * @param amountPayable the amountPayable to set
	 */
	public void setAmountPayable(int amountPayable) {
		this.amountPayable = amountPayable;
	}
	
	
		
}
