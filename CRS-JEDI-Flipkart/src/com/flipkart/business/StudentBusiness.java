package com.flipkart.business;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.Grade;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.FeePaymentDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.StudentDaoImpl;

public class StudentBusiness{
	
	public static Logger logger = Logger.getLogger(StudentBusiness.class);
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	CourseCatalogDaoImpl courseCatalogDaoObject = new CourseCatalogDaoImpl();
	FeePaymentDaoImpl feePaymentDaoObject = new FeePaymentDaoImpl();
	NotificationSystemDaoImpl notificationSystemDaoObject = new NotificationSystemDaoImpl();
	public int viewRegisteredCourses(int studentId) {
		ArrayList<Integer> courseList = studentDaoObject.viewRegisteredCourses(studentId);
		if(courseList.size() == 0) {
			logger.info("No registered courses");
		}
		else {
			logger.info("Course Id\tCourse Name");
			for(Integer course : courseList) {
				Course c = courseCatalogDaoObject.getCourse(course);
				logger.info(c.getCourseCode() +  "\t " + c.getCourseName());
			}
		}
		return courseList.size();
	}
	public void registerCourse(int studentId, int courseId) {
		studentDaoObject.registerCourse(studentId, courseId);
		logger.info("Added Course " + courseCatalogDaoObject.getCourse(courseId).getCourseName() + " in " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
		double addFees = GlobalConstants.feesOfSingleCourse;
		if(studentDaoObject.hasScholarship(studentId)) {
			addFees /= 10;
			addFees *=7;
		}
		feePaymentDaoObject.updateFees(studentId, feePaymentDaoObject.calculateFees(studentId) + addFees);
		
	}
	public void dropCourse(int studentId, int courseId) {
		studentDaoObject.dropCourse(studentId, courseId);
		logger.info("Removed Course " + courseCatalogDaoObject.getCourse(courseId).getCourseName() + " from " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
	}
	
	public void printReportCard(int studentId) {
		Student s = studentDaoObject.getStudent(studentId);
		logger.info("Student Id : " + s.getName() + "\nBranch : " + s.getBranch() + "\nEmail : " + s.getEmailId() + "\nGender : " + s.getGender() + "\nMobile :" + s.getMobile() + "\n");
		Map<Integer, Grade> grades = studentDaoObject.viewGrades(studentId);
		logger.info("Grades of " + studentDaoObject.getStudent(studentId).getName() + ":");
		for(Map.Entry<Integer, Grade> entry : grades.entrySet()) {
			logger.info(courseCatalogDaoObject.getCourse(entry.getKey()).getCourseName() + " : " + entry.getValue());
		}
		logger.info("\n\nReport Card Sent to :" + s.getEmailId());
	}
	public boolean checkValidCourseForStudent(int studentId, int courseId) {
		return courseCatalogDaoObject.validCourseForStudent(studentId, courseId);
	}
	
	
	public int numberOfRegisteredCourses(int studentId) {
		return courseCatalogDaoObject.numberOfRegisteredCourses(studentId);
	}
	public double getFees(int studentId) {
		return feePaymentDaoObject.calculateFees(studentId);
	}
	public void makePayment(int studentId, double fees, int choice) {
		
		//TodO
		//feePaymentDaoObject.payFees(studentId, fees, choice);
		feePaymentDaoObject.updateFees(studentId, 0);
		notificationSystemDaoObject.notifyUser(studentId, "Fees of " + fees + " Paid Successfully!");
		
	}
}