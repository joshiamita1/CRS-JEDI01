package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	

	// Get all users with particular role
	public ArrayList<Integer> getUsers(Role role);
	
	public String getPassword(int userId);

	User getUser(int userId);

	void deleteUser(int userId);

	void addUser(User user, String password);
}
