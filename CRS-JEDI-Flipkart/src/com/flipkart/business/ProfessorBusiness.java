  
package com.flipkart.business;

import java.util.Map;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.constant.Grade;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;


//ProfessorBusiness

public class ProfessorBusiness {
	
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
	CourseCatalogDaoImpl courseCatalogObject = new CourseCatalogDaoImpl();
	StudentDaoImpl studentDaoObject = new StudentDaoImpl();
	public static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
	// Grading student 
	public void gradeStudent(String courseCode, String studentId, Grade grade) {
		studentDaoObject.addGrade(studentId, courseCode, grade);
	}
  
	public void viewRegisteredStudents(String courseCode) {
     //  View all the RegisteredStudent in course
		Course course = courseCatalogObject.getCourse(courseCode);
		Map<String, Grade> mp = courseCatalogObject.viewGrades(courseCode);
		logger.info("Registered Students under " + professorDaoObject.getProfessor(courseCatalogObject.getCourse(courseCode).getProfessorId()).getName() + " for course " +  courseCatalogObject.getCourse(courseCode).getCourseName() + " are :");
		for(String s : mp.keySet()) {
			logger.info("Student ID : " + studentDaoObject.getStudent(s).getUserId() +"\n"+"Student Name" + studentDaoObject.getStudent(s).getName() + "\n");
		}
	}  
}