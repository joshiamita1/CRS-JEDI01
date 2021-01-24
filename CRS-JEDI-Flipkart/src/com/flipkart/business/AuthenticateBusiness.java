package com.flipkart.business;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

public class AuthenticateBusiness {
	
	UserDaoImpl userDaoObject = new UserDaoImpl();
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	AdminDaoImpl adminDaoObject = new AdminDaoImpl();
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
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
	}
	
	public boolean registerStudent(Student student, String password) {
		addUser(student, password);
		studentDaoObject.addStudent(student, password);
		return true;
	}

	public boolean registerAdmin(User admin, String password) {
		addUser(admin, password);
		adminDaoObject.addAdmin(admin, password);
		return true;
	}

	public boolean registerProfessor(User user, String password, Department department) {
		addUser(user, password);
		professorDaoObject.addProfessor(user, password, department);
		return true;
	}
}
