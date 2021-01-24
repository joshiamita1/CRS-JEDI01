package com.flipkart.business;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

public class AuthenticateBusiness {
	
	UserDaoImpl userDaoObject = new UserDaoImpl();
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
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
	
	public boolean registerStudent(Student s, String password) {
		userDaoObject.addUser(s, password);
		studentDaoObject.addStudent(s, password);
		return true;
	}

	public boolean registerAdmin(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean registerProfessor(User user, String password, Department department) {
		// TODO Auto-generated method stub
		return false;
	}
}
