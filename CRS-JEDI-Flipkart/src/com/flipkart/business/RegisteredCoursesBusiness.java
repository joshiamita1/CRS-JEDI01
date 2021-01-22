package com.flipkart.business;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.CourseNotFoundException;

public class RegisteredCoursesBusiness {
	
	public static Logger logger = Logger.getLogger(RegisteredCoursesBusiness.class);
	CourseCatalogDaoImpl courseCatalogObject = new CourseCatalogDaoImpl();
	
	//Need to create student dao implementation function
	StudentDao studentDao = (StudentDao) new StudentDaoImpl();
	public String dropCourses() {
		return null;
		
	}
	/**
	 * add courses
	 * @return
	 */
	public String addCourses() {
		//courseCatalogObject.addCourse(course);
		//get course from course catalog
		
		return null;
	}
	/**
	 * View List of courses
	 * @param student
	 * @return
	 */
	public String viewcourses(Student student) {
		
		ArrayList<Course> courseList = studentDao.viewRegisteredCourses(student.getStudentId());
		if(courseList.size() == 0) {
			logger.info("No registered courses");
		}
		else {
			logger.info("Course Id\tCourse Name");
			courseList.forEach(course -> logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName()));
		}
		
		logger.info("viewcourses function, RegisteredCoursesBusiness class");
		return null;
		
	}
}
