  
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
	public void gradeStudent(int courseId, int studentId, Grade grade) {
		studentDaoObject.addGrade(studentId, courseId, grade);
	}
	
	public boolean validCourseForProfessor(int professorId, int courseId) {
		return false;
		
	}
	public void viewAssignedCourses(int professorId) {
		
	}
	public void viewRegisteredStudents(int courseId) {
     //  View all the RegisteredStudent in course
		Course course = courseCatalogObject.getCourse(courseId);
		Map<String, Grade> mp = courseCatalogObject.viewGrades(courseId);
		logger.info("Registered Students under " + professorDaoObject.getProfessor(courseCatalogObject.getCourse(courseId).getProfessorId()).getName() + " for course " +  courseCatalogObject.getCourse(courseId).getCourseName() + " are :");
		for(String s : mp.keySet()) {
			logger.info("Student ID : " + studentDaoObject.getStudent(s).getUserId() +"\n"+"Student Name" + studentDaoObject.getStudent(s).getName() + "\n");
		}
	}  
}