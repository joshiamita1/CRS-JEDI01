  
package com.flipkart.business;

import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.constant.Grade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;


//ProfessorBusiness

public class ProfessorBusiness {
	
	private static ProfessorBusiness instance = null;
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
	private ProfessorBusiness() {
		
	}
	
	public static ProfessorBusiness getInstance() {
		if(instance==null) {
			instance = new ProfessorBusiness();
		}
		return instance;
	}
	
	
	// Grading student 
	public void gradeStudent(int courseId, int studentId, Grade grade) {
		studentDaoObject.addGrade(studentId, courseId, grade);
		logger.info("Added Grade " + grade);
		logger.info("Student :" + studentId);
		logger.info("Course Id : " + courseId);
	}
	
	public boolean validCourseForProfessor(int professorId, int courseId) {
		return courseCatalogDaoObject.validCourseForProfessor(professorId, courseId);
	}
	public void viewAssignedCourses(int professorId) {
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesForProfessor(professorId);
		logger.info("Course Id\tCourse Name");
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t " + course.getCourseName());
		}
		
	}
	public void viewRegisteredStudents(int courseId) {
     //  View all the RegisteredStudent in course
		Course course = courseCatalogDaoObject.getCourse(courseId);
		Map<Integer, Grade> mp = courseCatalogDaoObject.viewGrades(courseId);
		logger.info("Registered Students under " + professorDaoObject.getProfessor(courseCatalogDaoObject.getCourse(courseId).getProfessorId()).getName() + " for course " +  courseCatalogDaoObject.getCourse(courseId).getCourseName() + " are :");
		for(Integer s : mp.keySet()) {
			logger.info("Student ID : " + studentDaoObject.getStudent(s).getUserId() +"\n"+"Student Name" + studentDaoObject.getStudent(s).getName() + "\n");
		}
	}  
}