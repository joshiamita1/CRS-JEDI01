package com.flipkart.business;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDaoImpl;

//   CourseCatalogBusiness  Class

public class CourseCatalogBusiness{ 

	public static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	CourseCatalogDaoImpl courseCatalogDaoObject = new CourseCatalogDaoImpl();
	
	public void viewAllCourses() {   
		// CourseCode and CourseName of all the Courses in the semester  
		ArrayList<String> courseList = courseCatalogDaoObject.getCourses();
		logger.info("Course Id\tCourse Name");
		for(String courseCode : courseList) {
			Course course = getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
		}

	}
	
	// View Courses in particular Catalog
	public void viewCoursesInCatalog(int catalogId) {
		
	}
	
	public void addCourse(Course c) {
		
	}
	
	public void dropCourse(int catalogId) {
	}
	
	// Getting all the CourseInformation of a particular course 
	public Course getCourse(String courseCode) {
		Course course = courseCatalogDaoObject.getCourse(courseCode);
		logger.info(" Course Code" +  course.getCourseCode() +  "Course Name"+  "\t\t " + course.getCourseName());
		return course;
	}

	public int numberOfRegisterdStudents(int courseId) {
		// TODO Auto-generated method stub
		return 0;
	}

}