  
package com.flipkart.business;

import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.constant.Grade;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;


//ProfessorBusiness

public class ProfessorBusiness {
	
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
	CourseCatalogDaoImpl courseCatalogDaoObject = new CourseCatalogDaoImpl();
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	public static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
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