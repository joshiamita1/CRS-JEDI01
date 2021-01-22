package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;

public class GradeBusiness {
	
	public static Logger logger = Logger.getLogger(GradeBusiness.class);
	StudentDao studentDaoObj = new StudentDaoImpl();
		
	public void viewgrade(Student student) {
		try {
		studentDaoObj.viewGrades(student.getStudentId()).forEach((k,v) -> logger.info(k + "\t" + v));
		}catch(CourseNotFoundException ce) {
			logger.info("");
		}catch(Exception e) {
			
		}
		logger.info("viewgrade function, GradeBusiness class");
		
	}
}
