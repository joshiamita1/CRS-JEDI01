package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	
	/**
	 * Add User
	 * @param user
	 * @returnType void
	 */
	public void addUser(User user);
	
	/**
	 * Delete user from list of existing users
	 * @param userId
	 * @returnType void
	 */
	public void deleteUser(String userId);
	
	/**
	 * Modify details of a user
	 * @param userId
	 * @returnType void
	 */
	public void modifyUser(String userId);
	
	/**
	 * Get a list of ids of all users in the database
	 * @returnType List<String>
	 */
	public List<String> getUsers();
	
	/**
	 * Get users with a particular role(Student, professor or admin)
	 * @param role
	 * @returnType List<String>
	 */
	public List<String> getUsers(Role role);
	
	/**
	 * Get all details of a particular user
	 * @param userId
	 * @returnType User
	 */
	public User getUser(String userId);
}
