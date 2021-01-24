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
	
	
	public void approveStudent(int studentId) {
		if(studentDaoObject.getStudent(studentId)==null) {
			logger.info("Invalid Student ID");
		} else {
			studentDaoObject.approveStudent(studentId);
		}

	}
	// Getting all the users
	public void getUsers(Role role){
		userDaoObject.getUsers(role);
	}
	
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
	public void assignProfessor(int courseId, int professorId) {
		if(courseCatalogDaoObject.getCourse(courseId)==null) {
			logger.info("Invalid Course");
		} else if(professorDaoObject.getProfessor(professorId)==null) {
			logger.info("Invalid Professor");
		} else {
			logger.info("Assigned Successfully");
		}

	}
}
