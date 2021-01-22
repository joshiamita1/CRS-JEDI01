<<<<<<< HEAD
/**
 * 
 */
package com.flipkart.dao;
import java.util.*;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

/**
 * @author surya
 *
 */
public interface AdminDao {
	public ArrayList<User> viewUsers();
	public void assignProfessor(Professor professor, int courseId);
	public String addNewCourseInCatalog(Course course);
	public void deleteUser(int userId);
=======
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface AdminDao {
	// Add Admin
	public void addAdmin(User admin);
	
	// Delete Admin
	public void deleteAdmin(String adminId);
>>>>>>> d2dbf3be979b8aa8ce20ec1aad6621f589964c61
}
