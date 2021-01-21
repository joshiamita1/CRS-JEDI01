package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.business.AdminBusiness;

public class AdminClient {

	
		
		private static Logger logger = Logger.getLogger(ProfessorClient.class);
		Scanner sc = new Scanner(System.in);
		AdminBusiness adminclient = new AdminBusiness(); 

	public void displayMenu(Professor professor) {
			
		int choice=-1;
		do {
			logger.info("ADMIN CAN PERFORM FOLLOWING ACTIONS:");
			logger.info("1. Approve student");
			logger.info("2. Register professor");
			logger.info("3. Register Admin");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			case 1:
				adminclient.approvestudents();
				
				break;
			case 2:
				adminclient.registerprofessor();
				
				break;
			case 3:
              adminclient.registeradmin();
              break;
			
			default: logger.info("PLEASE ENTER A VALID CHOICE");
			}
		
		}
		while(choice!=9);
		sc.close();	
		}
		
	}

