package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

public class AuthenticateBusiness {
	public static Logger logger = Logger.getLogger(AuthenticateBusiness.class);
	// Singleton Field
	private static AuthenticateBusiness instance = null;
	
	// Dao Objects
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();

	
	// Private Constructor
	private AuthenticateBusiness() {
		logger.info("Constructor of Authenticate Business");
	}
	
	// Get Instance of the class
	public static AuthenticateBusiness getInstance() {
		if(instance==null) {
			instance = new AuthenticateBusiness();
		}
		return instance;
	}
	
	// Check if credentials match with any user
	public boolean validLogin(int inputId, String inputPassword) {
		try {
			String userPassword = userDaoObject.getPassword(inputId);
			if(userPassword.equals(inputPassword)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	// Returns role of the user, once credentials are passed	
	public Role getRole(int inputId, String inputPassword) {
		return userDaoObject.getUser(inputId).getRole();
		
	}
	
	public void testing() {
		logger.info("SSSS");
		logger.debug("DEbugging");
		System.out.print("Checking");
	}
	
	// Register Student in Database
	public boolean registerStudent(Student student, String password) {
		
		studentDaoObject.addStudent(student, password);
		logger.info("Added user into Student Table\n");
		logger.info(student.getUserId());
		notificationSystemDaoObject.notifyUser(student.getUserId(), "Successfully Registerd!");
		return true;
	}

	// Register Admin in Database
	public boolean registerAdmin(User admin, String password) {
		adminDaoObject.addAdmin(admin, password);
		logger.info("Added user into Admin Table\n");
		return true;
	}

	// Register Professor in Database
	public boolean registerProfessor(User user, String password, Department department) {
		professorDaoObject.addProfessor(user, password, department);
		logger.info("Added user into Professor Table\n");
		return true;
	}
}
