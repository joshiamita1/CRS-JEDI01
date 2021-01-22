package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.CourseNotFoundException;

public class StudentBusiness{
	
	public static Logger logger = Logger.getLogger(StudentBusiness.class);
	StudentDao studentDao = new StudentDaoImpl();
	
	/**
	 * Option to pay fee
	 * @param student
	 */
	public void payFee(Student student) {
		
		logger.info("payfee function, StudentBusiness class");
		
	}
	/**
	 * Select courses from the remaining courses
	 * @param student
	 */
	public void selectCourses(Student student) {
		
		
		logger.info("selectcourses function, StudentBusiness class");
		
	}
	/**
	 * To View report card
	 * @param student
	 */
	public void viewReportCard(Student student) {
		
		studentDao.viewGrades(student.getStudentId()).forEach((k,v) -> logger.info(k + "\t" + v));
		logger.info("viewreportcard function, StudentBusiness class");
		
	}
	/**
	 * Function to add courses in student preexisting list of courses
	 * @param courseId
	 * @param student
	 */
	public void addCourses(String courseId, Student student) {
		
		private static Logger logger = Logger.getLogger(AdminOperation.class);
		AdminDao adminDao = new AdminDaoImpl();
		try {
			studentDao.addCourse(courseId, student.getStudentId());
		}catch(CourseNotFoundException ce) {
			logger.error(ce.getCourseName() + "not found");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			logger.info("course add function");
		}
		logger.info("addcourses function, RegisteredCoursesBusiness class");
		//logger.info("addcourses function, StudentBusiness class");
		
	}
	/**
	 * Option to drop course from existing list of registered courses
	 * @param courseId
	 * @param student
	 */
	public void dropcourses(String courseId, Student student) {
		//added Course not found exception
		try {
			studentDao.dropCourse(courseId, student.getStudentId());
		}catch(CourseNotFoundException ce) {
			logger.error(ce.getCourseName() + "not found");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			logger.info("course delete function");
		}
		
		logger.info("dropcourses function, RegisteredCoursesBusiness class");
		
	}
	
	
}
