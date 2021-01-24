
/**
 * 
 */
package com.flipkart.dao;
import java.util.*;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
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
	public void deleteAdmin(int userId);
}
