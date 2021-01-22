package com.flipkart.business;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;

public class CourseCatalogBusiness {
	
	public static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	StudentDao studentDao = new StudentDaoImpl();
	/**
	 * view courses, later add db part
	 * @param student
	 */
	public void viewcourses(Student student) {
	 
		String studentName = student.getName();
		ArrayList<Course> courseList = studentDao.viewRegisteredCourses(studentName);
		if(courseList.size() == 0) {
			logger.info("No registered courses");
		}
		else {
			logger.info("Course Id\tCourse Name");
			courseList.forEach(course -> logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName()));
		}
	 System.out.println("viewcourses function, CourseCatalogBusiness class");
 }
}
