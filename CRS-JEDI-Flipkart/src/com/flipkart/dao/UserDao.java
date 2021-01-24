package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	
	// Add User
	public void addUser(User user);
	
	// Delete User
	public void deleteUser(String userId);
	
	// Modify User
	public void modifyUser(String userId);
	

	// Get all usersId
	public List<String> getUsers();

	// Get all users with particular role, return userId
	public List<String> getUsers(Role role);
	
	// Get User
	public User getUser(String userId);
}
