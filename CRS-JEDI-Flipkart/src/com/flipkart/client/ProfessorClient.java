package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Grade;


public class ProfessorClient {
	
	// Logger
	private static Logger logger = Logger.getLogger(ProfessorClient.class);
	
	// Scanner
	Scanner sc = new Scanner(System.in);
	
	// Business Objects
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	ProfessorBusiness professorBusinessObject = ProfessorBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	
	// Functionalities of the Professor
	public void displayMenu(int professorId) {
		int choice;
		do {
			printChoices();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				courseCatalogBusinessObject.viewAllCourses();
				break;
			case 2:
				professorBusinessObject.viewAssignedCourses(professorId);
				break;
			case 3:
				viewRegisteredStudents(professorId);
				break;
			case 4:
				gradeStudent(professorId);
				break;
			case 0:
				break;
			default:
				logger.info("Invalid Choice.\nTry Again\n");
				break;
			}
			
		}while(choice!=0);
		sc.close();	
	}
	
	// View Registered Students in the course
	public void viewRegisteredStudents(int professorId) {
		logger.info("Enter Course ID");
		int courseId = sc.nextInt();
		if(professorBusinessObject.validCourseForProfessor(professorId, courseId)) {
			professorBusinessObject.viewRegisteredStudents(courseId);
		} else {
			logger.info("This Course is not taught by you!");
		}

	}
	
	// Grade Student
	public void gradeStudent(int professorId) {
		logger.info("Enter Course ID");
		int courseId = sc.nextInt();
		// Check if course is taught by professor
		if(professorBusinessObject.validCourseForProfessor(professorId, courseId)) {
			professorBusinessObject.viewRegisteredStudents(courseId);
			logger.info("Please Select the Id of the student you want to Grade!");
			int studentId = sc.nextInt();
			// Chceck if student is enrolled in the course
			if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
				logger.info("Enter grade: (A,B,C,D,E)");
				Grade grade = Grade.valueOf(sc.nextLine());
				professorBusinessObject.gradeStudent(courseId, studentId, grade);
			}
			else {
				logger.info("Student has not registered for this course");
			}
		} else {
			logger.info("This Course is not taught by you!");
		}
	}
	
	// Display Available Features
	public void printChoices() {
		logger.info("Enter your choice:");
		logger.info("1. To view available courses");
		logger.info("2. To view courses assigned");
		logger.info("3. To view students in a course");
		logger.info("4. Grade a student");
		logger.info("0. To logout");
	}

}