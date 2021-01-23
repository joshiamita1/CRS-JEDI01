package com.flipkart.dao;

public interface NotificationSystem {

	/**
	 * Notify user with a given message
	 * @param userID
	 * @param Message
	 * @returnType void
	 */
	public void notifyUser(int userID, String Message);
}
