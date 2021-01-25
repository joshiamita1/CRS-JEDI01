package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;

//This is student client class that gives different options to student

public class StudentClient {

	private static Logger logger = Logger.getLogger(StudentClient.class);
	Scanner sc = new Scanner(System.in);

	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	// Displays the Student Menu with choices for student
	public void displayMenu(int studentId) {
		printChoices();
		int choice;
		do {
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				courseCatalogBusinessObject.viewAllCourses();
				break;
			case 2:
				registerCourse(studentId);
				break;
			case 3:
				dropCourse(studentId);
				break;
			case 4:
				viewRegisteredCourses(studentId);
				break;
			case 5:
				payFees(studentId);
				break;
			case 6:
				printReportCard(studentId);
				break;
			case 0:
				break;
			default:
				logger.info("Invalid Choice./nTry Again\n");
				break;
			}
		}while(choice!=0);
		
	}
	
	// Show choices
	void printChoices() {
		logger.info("Enter your choice:");
		logger.info("1. To view available courses");
		logger.info("2. To register a course");
		logger.info("3. To drop a course");
		logger.info("4. View registered courses");
		logger.info("5. Pay fees");
		logger.info("6. Print Report Card");
		logger.info("0. To logout");
	}
	
	public void registerCourse(int studentId) {
		if(studentBusinessObject.numberOfRegisteredCourses(studentId)==4) {
			logger.info("You cannot add courses as you have already selected 4 courses");
		} else{
			int courseId = sc.nextInt();
			if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
				logger.info("You are already Registered for this course");
			}
			else if(courseCatalogBusinessObject.numberOfRegisterdStudents(courseId)==10) {
				logger.info("10 Students already Registerd for the course so you can't register");
			} else {
				studentBusinessObject.registerCourse(studentId, courseId);
			}
		}
	}
	
	public void dropCourse(int studentId) {
		logger.info("Enter the course ID");
		int courseId = sc.nextInt();
		if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
			studentBusinessObject.dropCourse(studentId, courseId);
		} else {
			logger.info("You were not registered for this course");
		}
	}
	
	public void viewRegisteredCourses(int studentId) {
		studentBusinessObject.viewRegisteredCourses(studentId);
	}
	
	public void payFees(int studentId) {
		double fees = studentBusinessObject.getFees(studentId);
		if(fees==0) {
			logger.info("No dues pending!");
		}
		else{
			logger.info("Pending Fees = " + fees + "INR-/ only!");
			logger.info("Please Choose Mode of the Payment\n1. To pay with Credit Card\n2. To pay using cash \n3. To pay using Net Banking");
			int choice = sc.nextInt();
			if(choice>=1 && choice <= 3) {
				studentBusinessObject.makePayment(studentId, fees, choice);
			} else {
				logger.info("Invalid Mode.\nTranscation Terminated.");
			}
		}
		
	}
	
	public void printReportCard(int studentId) {
		studentBusinessObject.printReportCard(studentId);
	}
}