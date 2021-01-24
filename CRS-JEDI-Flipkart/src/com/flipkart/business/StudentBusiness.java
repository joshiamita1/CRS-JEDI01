package com.flipkart.business;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.Grade;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.StudentDaoImpl;

public class StudentBusiness{
	
	public static Logger logger = Logger.getLogger(StudentBusiness.class);
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	CourseCatalogDaoImpl courseCatalogDaoObject = new CourseCatalogDaoImpl();
	public int viewRegisteredCourses(String studentId) {
		ArrayList<Course> courseList = studentDaoObject.viewRegisteredCourses(studentId);
		if(courseList.size() == 0) {
			logger.info("No registered courses");
		}
		else {
			logger.info("Course Id\tCourse Name");
			for(Course course : courseList) {
				logger.info(course.getCourseCode() +  "\t " + course.getCourseName());
			}
		}
		return courseList.size();
	}
	public void registerCourse(String studentId, String courseCode) {
		studentDaoObject.registerCourse(studentId, courseCode);
		logger.info("Added Course " + courseCatalogDaoObject.getCourse(courseCode).getCourseName() + " in " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
	}
	public void dropCourse(String studentId, String courseCode) {
		studentDaoObject.dropCourse(studentId, courseCode);
		logger.info("Removed Course " + courseCatalogDaoObject.getCourse(courseCode).getCourseName() + " from " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
	}
	
	public void viewGrades(String studentId) {
		Map<String, Grade> grades = studentDaoObject.viewGrades(studentId);
		logger.info("Grades of " + studentDaoObject.getStudent(studentId).getName() + ":");
		for(Map.Entry<String, Grade> entry : grades.entrySet()) {
			logger.info(courseCatalogDaoObject.getCourse(entry.getKey()).getCourseName() + " : " + entry.getValue());
		}
	}
	
	public void printReportCard(String studentId) {
		Student s = studentDaoObject.getStudent(studentId);
		logger.info("Student Id : " + s.getName() + "\nBranch : " + s.getBranch() + "\nEmail : " + s.getEmailId() + "\nGender : " + s.getGender() + "\nMobile :" + s.getMobile() + "\n");
		viewGrades(studentId);
		logger.info("\n\nReport Card Sent to :" + s.getEmailId());
	}
	
	public void calculateFees(String studentId) {
		int noOfCourses = viewRegisteredCourses(studentId);
		logger.info("Total Fees : " + noOfCourses*GlobalConstants.feesOfSingleCourse);
	}
	/*
	 * Notification System
	 * */
}