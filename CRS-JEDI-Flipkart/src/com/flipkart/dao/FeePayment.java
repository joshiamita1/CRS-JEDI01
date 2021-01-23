package com.flipkart.dao;

public interface FeePayment {

	/**
	 * Calculate fee for a student
	 * @param studentId
	 * @returnType double
	 */
	public double calculatefees(int studentId);
	
	/**
	 * Count courses for a student
	 * @param studentid
	 * @returnType int
	 */
	public int countcourses(int studentid);
	
	/**
	 * Update fee for a student 
	 * @param StudentId
	 * @param fees
	 * @returnType void
	 */
	public void updatefees(int StudentId, double fees);
	
	/**
	 * Return payable fee 
	 * @param StudentId
	 * @returnType double
	 */
	public double getFeesToPay(int StudentId);
}
