package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;

public class StudentClient {
	
	private static Logger logger = Logger.getLogger(StudentClient.class);
	
	public Student student;
	StudentDao studentOperation = new StudentDaoImpl();
	Scanner sc = new Scanner(System.in);

	// Displays the Student Menu with choices for student
	public void displayMenu(Student student) {
		int choice;
		do {
			this.student = student;
			logger.info("Student CAN PERFORM FOLLOWING ACTIONS:");
			logger.info("1. View Catalog");
			logger.info("2. Choose Course");
			logger.info("3. Drop Course");
			logger.info("4. View Registered Course");
			logger.info("5. Pay Fee");
			logger.info("6. Print Report Card ");
			logger.info("7. Logout");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					studentOperation.viewCatalog();
					break;
					
				case 2:
					chooseCourse();
					break;
					
				case 3:
					dropCourse();
					break;
				
				case 4:
					studentOperation.viewRegisteredCourses());
					break;
					
				case 5:
					payFees();
					break;
					
				case 6:
					viewGrades();
					break;
					
				case 0:
					UserClient.logout();
			}
			
		}while(UserClient.loggedIn);
		sc.close();	
		
		/**
		 * Option 2 to chose from the remaiing courses
		 */
		void chooseCourse() {
			if(studentOperation.(student) >= 4) {
				logger.info("You cannot add courses as you have already selected 4 courses");
			}
			else {
				logger.info("Enter courseId");
				int courseId = Integer.parseInt(sc.nextLine());
				studentOperation.chooseCourse(student, courseId);
			}
			
		}
		
		
		void dropCourse() {
			Course course1 = new Course();
			logger.info("Enter course id:");
			int courseId = Integer.parseInt(sc.nextLine());
			course1.setCourseId(courseId);
			studentOperation.dropCourse(course1, student);
		}
		
		// print report card for student
		void printReportCard() {
			logger.info("--------Report Card--------");
			logger.info("Course\tGrade");
			studentOperation.viewGrades(student);
			logger.info("---------------------------");
		}
		
		// Get amount to be paid and make payment
		void payFees() {
			int fee = studentOperation.calculateTotalFee(student);
			logger.info("Want to continue to pay Rs."+ fee + " press 'y' to continue...");
			if(sc.nextLine().equals("y")) {
				logger.info("Enter 1 to pay with credit card.");
				logger.info("Enter 2 to pay with debit card.");
				logger.info("Enter 3 to pay as cash.");
				int choice = Integer.parseInt(sc.nextLine());
				if(choice >= 1 && choice <= 3) {
					studentOperation.makePayment(student, choice, fee);
				}
				else {
					logger.info("Cannot do such payment!!");
				}
			}
			else {
				logger.info("Payment not done.");
			}
		}
}
