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
