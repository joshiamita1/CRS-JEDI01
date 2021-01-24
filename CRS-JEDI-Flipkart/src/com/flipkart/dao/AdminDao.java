package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminDao {
	// Add Admin
	public void addAdmin(User admin);
	
	// Delete Admin
	public void deleteAdmin(String adminId);

	void deleteAdmin(int userId);

	void addAdmin(User admin, String password);
}
