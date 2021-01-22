package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	
	// Add User
	public void addUser(User user);
	
	// Delete User
	public void deleteUser(String userId);
	
	// Modify User
	public void modifyUser(String userId);
	
	// Get all users
	public void getUsers();
	
	// Get all users with particular role
	public void getUsers(Role role);
	
	// Get User
	public User getUser(String userId);
}
