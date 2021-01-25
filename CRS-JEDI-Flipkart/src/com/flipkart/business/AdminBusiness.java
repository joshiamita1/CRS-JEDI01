
package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

// Admin Business

public class AdminBusiness{
	
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
	CourseCatalogDaoImpl courseCatalogDaoObject = new CourseCatalogDaoImpl();
	UserDaoImpl userDaoObject = new UserDaoImpl();
	AdminDaoImpl adminDaoObject = new AdminDaoImpl();
	private static Logger logger = Logger.getLogger(AdminBusiness.class);
	public void approveStudent(String studentId) {
		Student s = studentDaoObject.getStudent(studentId);
		s.setApproved(true);
		studentDaoObject.modifyStudent(studentId, s);
	}

	// Registering User
	public void registerUser(User user) { 
		userDaoObject.addUser(user);

	}
	
	public void registerAdmin(User admin) {
		registerUser(admin);
		adminDaoObject.addAdmin(admin);
	}

	// Registering Professor
	public void registerProfessor(Professor professor){

		registerUser(professor);
		professorDaoObject.addProfessor(professor);
	}
	
	// Adding courses in the semester
	public void addNewCourse(Course course) {
		courseCatalogDaoObject.addCourse(course);

	}

	// Deleting courses in the semester
	public void deleteCourse(String courseCode) {

		courseCatalogDaoObject.deleteCourse(courseCode);
	}

	// Getting all the users
	public void getUsers(Role role){
		userDaoObject.getUsers(role);
	}

}
=======
package com.flipkart.business;

import java.util.ArrayList;

import org.apache.log4j.Logger;


import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

/**
 * @author JEDI01
 * Admin Business
 */
public class AdminBusiness{
	
	
	/**
	 * Singleton Field
	 */
	private static AdminBusiness instance = null;

	/**
	 * Dao Objects 
	 */
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(AdminBusiness.class);
	
	
	
	/**
	 * Private Constructor
	 */
	private AdminBusiness() {
		
	}
	
	/**
	 * @return instance
	 */
	public static AdminBusiness getInstance() {
		if(instance==null) {
			instance = new AdminBusiness();
		}
		return instance;
	}
	
	/**
	 * @param studentId
	 */
	public void approveStudent(int studentId) {
		if(studentDaoObject.getStudent(studentId)==null) {
			logger.info("Invalid Student ID");
		} else {
			studentDaoObject.approveStudent(studentId);
			logger.info("Student Approved");
		}

	}
	

	
	/**
	 * @param role
	 * Get Users with the particular role
	 */
	public void getUsers(Role role){
		ArrayList<Integer> users= userDaoObject.getUsers(role);
		logger.info("Users of the role : " + role + " are :");
		for(Integer user : users) {
			User u = userDaoObject.getUser(user);
			logger.info("Name : " + u.getName());
			logger.info("User Id : " + user);
		}
	}
	
	/**
	 * @param userId
	 * Delete user
	 */
	public void deleteUser(int userId) {
		Role role = userDaoObject.getUser(userId).getRole();
		userDaoObject.deleteUser(userId);
		switch(role) {
		case ADMIN:
			adminDaoObject.deleteAdmin(userId);
		case STUDENT:
			studentDaoObject.deleteStudent(userId);
		case PROFESSOR:
			professorDaoObject.deleteProfessor(userId);
		}
	}
	
	/**
	 * @param courseId
	 * @param professorId
	 * Assign Professor to the course
	 */
	public void assignProfessor(int courseId, int professorId) {
		// Check if course is invalid
		if(courseCatalogDaoObject.getCourse(courseId)==null) {
			logger.info("Invalid Course");
		}
		// Check if professor is invalid
		else if(professorDaoObject.getProfessor(professorId)==null) {
			logger.info("Invalid Professor");
		}
		else {
			courseCatalogDaoObject.assignProfessor(courseId, professorId);
			logger.info("Assigned Successfully");
		}

	}
}

