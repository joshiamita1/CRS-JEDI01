  
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



/**
 * @author JEDI01
 *
 */

public class ProfessorBusiness {
	
	/**
	 * Singleton Field
	 */
	private static ProfessorBusiness instance = null;
	
	
	/**
	 * Dao Objects
	 */
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
	// Private Constructor
	private ProfessorBusiness() {
		
	}
	
	/**
	 * @return Instance of the class
	 */
	public static ProfessorBusiness getInstance() {
		if(instance==null) {
			instance = new ProfessorBusiness();
		}
		return instance;
	}
	
	
	/**
	 * @param courseId
	 * @param studentId
	 * @param grade
	 */
	public void gradeStudent(int courseId, int studentId, Grade grade) {
		studentDaoObject.addGrade(studentId, courseId, grade);
		logger.info("Added Grade " + grade);
		logger.info("Student :" + studentId);
		logger.info("Course Id : " + courseId);
		logger.info("======================STUDENT GRADED======================");
	}
	
	
	/**
	 * @param professorId
	 * @param courseId
	 * @return if given professor teaches the given course
	 */
	public boolean validCourseForProfessor(int professorId, int courseId) {
		
		return courseCatalogDaoObject.validCourseForProfessor(professorId, courseId);
	}
	
	
	/**
	 * @param professorId
	 */
	public void viewAssignedCourses(int professorId) {
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesForProfessor(professorId);
		logger.info("Course Id\t Course Name");
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t " + course.getCourseName());
		}
		
	}
	
	
	/**
	 * @param courseId
	 */
	public void viewRegisteredStudents(int courseId) {
     //  View all the RegisteredStudent in course
		Map<Integer, Grade> mp = courseCatalogDaoObject.viewGrades(courseId);
		logger.info("Registered Students under " + professorDaoObject.getProfessor(courseCatalogDaoObject.getCourse(courseId).getProfessorId()).getName() + " for course " +  courseCatalogDaoObject.getCourse(courseId).getCourseName() + " are :");
		for(Integer s : mp.keySet()) {
			logger.info("Student ID : " + studentDaoObject.getStudent(s).getUserId() +"\n"+"Student Name" + studentDaoObject.getStudent(s).getName() + "\n");
		}
	}  
}