package com.flipkart.dao;

public interface FeePayment {

	public double calculatefees(int studentId);
	public int countcourses(int studentid);
	public void updatefees(int StudentId, double fees);
	public double getFeesToPay(int StudentId);
}
