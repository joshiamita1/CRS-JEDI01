package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
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
	
	UserDaoImpl userDaoObject = new UserDaoImpl();
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	AdminDaoImpl adminDaoObject = new AdminDaoImpl();
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
	NotificationSystemDaoImpl notificationSystemDaoObject = new NotificationSystemDaoImpl();
	private static Logger logger = Logger.getLogger(AuthenticateBusiness.class);
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
	
	public Role getRole(int inputId, String inputPassword) {
		return userDaoObject.getUser(inputId).getRole();
		
	}
	
	public void addUser(User user, String password) {
		userDaoObject.addUser(user, password);
		logger.info("Added user into User Table\n");
	}
	
	public boolean registerStudent(Student student, String password) {
		
		studentDaoObject.addStudent(student, password);
		logger.info("Added user into Student Table\n");
		//notificationSystemDaoObject.notifyUser(student.getUserId(), "Successfully Registerd!");
		return true;
	}

	public boolean registerAdmin(User admin, String password) {
		adminDaoObject.addAdmin(admin, password);
		logger.info("Added user into Admin Table\n");
		return true;
	}

	public boolean registerProfessor(User user, String password, Department department) {
		professorDaoObject.addProfessor(user, password, department);
		logger.info("Added user into Professor Table\n");
		return true;
	}
}
