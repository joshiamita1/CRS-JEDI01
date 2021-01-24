package com.flipkart.dao;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> lovish
import java.util.List;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	
<<<<<<< HEAD
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
	public void modifyUser(String userId, User user);
	
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
=======

	// Get all users with particular role
	public ArrayList<Integer> getUsers(Role role);
	
	public String getPassword(int userId);

	User getUser(int userId);

	void deleteUser(int userId);

	void addUser(User user, String password);
>>>>>>> lovish
}
