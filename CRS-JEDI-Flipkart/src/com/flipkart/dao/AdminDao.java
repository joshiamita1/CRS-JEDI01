package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminDao {
	/**
	 * Adds an admin
	 * @param admin
	 */
	public void addAdmin(User admin);
	
	/**
	 * Deletes an admin
	 * @param adminId
	 */
	public void deleteAdmin(String adminId);
}
