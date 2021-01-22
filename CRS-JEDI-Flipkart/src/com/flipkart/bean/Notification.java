package com.flipkart.bean;

import java.util.Date;

public class Notification {
	String notificationId;
	String message;
	String userId;
	Date timeNotified;
	/**
	 * @return the notificationId
	 */
	public String getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the timeNotified
	 */
	public Date getTimeNotified() {
		return timeNotified;
	}
	/**
	 * @param timeNotified the timeNotified to set
	 */
	public void setTimeNotified(Date timeNotified) {
		this.timeNotified = timeNotified;
	}
	
	
}
