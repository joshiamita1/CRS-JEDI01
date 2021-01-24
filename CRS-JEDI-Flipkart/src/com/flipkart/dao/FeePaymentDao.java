package com.flipkart.dao;

public interface FeePaymentDao {

	
	/**
	 * Calculate fee for a student
	 * @param studentId
	 * @returnType double
	 */
	public double calculateFees(int studentId);
	
	/**
	 * Count courses for a student
	 * @param studentid
	 * @returnType int
	 */
	public int countCourses(int studentid);
	
	/**
	 * Update fee for a student 
	 * @param StudentId
	 * @param fees
	 * @returnType void
	 */
	public void updateFees(int StudentId, double fees);
	
	/**
	 * Return payable fee 
	 * @param StudentId
	 * @returnType double
	 */
	public double getFeesToPay(int StudentId);
}