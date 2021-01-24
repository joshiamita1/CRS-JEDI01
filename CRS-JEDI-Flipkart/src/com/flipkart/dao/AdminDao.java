package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminDao {
	// Add Admin
	void addAdmin(User admin, String password);
	
	// Delete Admin
	void deleteAdmin(int userId);


}
