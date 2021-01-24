package com.flipkart.dao;

public interface FeePaymentDao {

	// Return Amount Payable of the Student
	public double calculateFees(int studentId);
	
	// Update the fees of the student
	public void updatefees(int StudentId, double d);
}
