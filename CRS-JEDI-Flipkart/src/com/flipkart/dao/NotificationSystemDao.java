package com.flipkart.dao;

public interface NotificationSystemDao {

	// Notify User with the message
	public void notifyUser(int userID, String Message);
}
