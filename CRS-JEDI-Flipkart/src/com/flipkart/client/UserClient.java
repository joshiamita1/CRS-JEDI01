package com.flipkart.client;

import org.apache.log4j.Logger;

import com.flipkart.constant.Gender;
import com.flipkart.constant.GlobalConstants;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.Role;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.util.UserIdGenerator;

import java.util.*;
public class UserClient {
	
	// Logger Object
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	// Scanner Class
	static Scanner sc = new Scanner(System.in);
	
	// User Database Interaction Object
	UserDaoImpl userDaoObject = new UserDaoImpl();
	
	// Student Database Interaction Object
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
		
	// Professor Client Menu Object
	ProfessorClient professorClient = new ProfessorClient();
	
	// Student Client Menu Object
	StudentClient studentClient = new StudentClient();
	
	// Admin Client Menu Object
	AdminClient adminClient = new AdminClient();
	
	// Enter Point of the Application
	public static void main(String[]args) {
		logger.info("Welcome to the Course Registration System");
		
		// Displaying Login Portal
		showUserMenu();
		
		logger.info("Exiting CRS");		
	}
	
	public static void showUserMenu() {
		boolean showMenu=true;
		int choice;
		do {
			logger.info("======User Menu=====");
			logger.info("Enter 1 to Login");
			logger.info("Enter 2  to Register (if you are student)");
			logger.info("Enter any other number to exit CRS");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
				case 1:
					new UserClient().login();
					break;
				case 2:
					new UserClient().registerStudent();
					break;
				default:
					showMenu = false;
					logger.error("=====Exiting=====");
					break;
			}
		}while(showMenu);
		
	}
	

	public void login() {
		logger.info("Enter User Id");
		String userId = sc.nextLine();
		logger.info("Enter User Password");
		String password = sc.nextLine();
		if (valid(userId, password)){
				User u = userDaoObject.getUser(userId);
				Role r = u.getRole();
				logger.info("Welcome " + u.getName());
				switch(r) {
				case ADMIN :
					logger.info("Successfully Logged in as Admin");
					adminClient.displayMenu();
					break;
				case PROFESSOR:
					professorClient.displayMenu();
					break;
				case STUDENT:
					studentClient.displayMenu();
					break;
				}
		}
	}

	void registerStudent() {
		String userId, name, password, branch, email;
		long mobile;
		Gender gender;
		boolean hasScholarship = false;
		userId = UserIdGenerator.generateId(null);
		logger.info("Enter Name");
		name = sc.nextLine();
		logger.info("Enter Password");
		password = sc.nextLine();
		logger.info("Enter Email");
		email = sc.nextLine();
		logger.info("Enter Mobile No.");
		mobile = sc.nextLong();
		logger.info("Enter Branch");
		branch = sc.nextLine();
		logger.info("Select Gender: 'M' for male and 'F' for female");
		gender = Gender.valueOf(sc.nextLine());
		logger.info("If you have scholarship enter 1, else enter 0");
		int scholarShip = Integer.parseInt(sc.nextLine());
		if(scholarShip == 1) hasScholarship = true;
		
		Student s = new Student(userId, email, password, name, mobile, Role.STUDENT, gender, branch, hasScholarship, false);
		userDaoObject.addUser(s);
		studentDaoObject.addStudent(s);
		logger.info("Successfully Registered! Your user id is " + userId + ".");
		logger.info("Login Again!");
	}
	
	boolean valid(String userId, String password) {
		try {
			User u = userDaoObject.getUser(userId);
			if(u.getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}


}
