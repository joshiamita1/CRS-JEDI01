package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;

public class ReportCardBusiness {

	public static Logger logger = Logger.getLogger(ReportCardBusiness.class);
	StudentDao studentOperation = new StudentDaoImpl();
	
	/**
	 * Print students report card
	 * @param student
	 */
	public void printreportcard(Student student) {
		
		logger.info("--------Report Card--------");
		logger.info("Course\tGrade");
		studentOperation.viewGrades(student);
		logger.info("---------------------------");
		
	}
}
