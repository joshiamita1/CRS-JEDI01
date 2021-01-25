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

// Admin Business

public class AdminBusiness{
	
	// Singleton Field
	private static AdminBusiness instance = null;
	
	// Dao Objects
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(AdminBusiness.class);
	
	// Private Constructor
	private AdminBusiness() {
		
	}
	
	// Get Instance of the class
	public static AdminBusiness getInstance() {
		if(instance==null) {
			instance = new AdminBusiness();
		}
		return instance;
	}
	
	// Approve the Student
	public void approveStudent(int studentId) {
		if(studentDaoObject.getStudent(studentId)==null) {
			logger.info("Invalid Student ID");
		} else {
			studentDaoObject.approveStudent(studentId);
			logger.info("Student Approved");
		}

	}
	

	
	//Getting all the users of particular role
	public void getUsers(Role role){
		ArrayList<Integer> users= userDaoObject.getUsers(role);
		logger.info(users.size());
		logger.info("Users of the role :" + role + "are :");
		for(Integer user : users) {
			User u = userDaoObject.getUser(user);
			logger.info("Name : " + u.getName());
			logger.info("Email : " + u.getEmailId());
			logger.info("User Id : " + u.getUserId());
		}
	}
	
	// Delete user when ID is provided
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
	
	// Assign Professor to the course
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
