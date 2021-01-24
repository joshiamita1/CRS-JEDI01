package com.flipkart.client;
import org.apache.log4j.Logger;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
public class ProfessorClient {
	
	private static Logger logger = Logger.getLogger(ProfessorClient.class);
	Scanner sc = new Scanner(System.in);
	ProfessorBusiness profbusiness = new ProfessorBusiness(); 

public void displayMenu() {
		
	int choice=-1;
	do {
		logger.info("Select action to perform:");
		logger.info("1. To view students in a course");
		logger.info("2. Grade a student");
		logger.info("9. To logout");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		
		case 1:
			break;
		case 2:
			break;
		case 9:break;
		default: logger.info("eneter a valid choice");
		}
	
	}while(choice!=9);
	//sc.close();	
	UserClient.showUserMenu();
	}
}

