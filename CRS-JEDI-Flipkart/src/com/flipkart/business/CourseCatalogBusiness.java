package com.flipkart.business;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDaoImpl;

//   CourseCatalogBusiness  Class

public class CourseCatalogBusiness{ 

	// Singleton Field
	private static CourseCatalogBusiness instance = null;
	
	// Dao Objects
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	
	// Private Constructor
	private CourseCatalogBusiness() {
		
	}
	
	// Get Instance of the class
	public static CourseCatalogBusiness getInstance() {
		if(instance==null) {
			instance = new CourseCatalogBusiness();
		}
		return instance;
	}
	
	// View all the Courses
	public void viewAllCourses() {   
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCourses();
		logger.info("Course Id\tCourse Name");
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
		}

	}
	
	// View Courses in particular Catalog
	public void viewCoursesInCatalog(int catalogId) {
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesInCatalog(catalogId);
		logger.info("Course Id\tCourse Name");
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
		}
	}
	
	// Add Course to the Catalog
	public void addCourse(Course c) {
		courseCatalogDaoObject.addCourse(c);
		logger.info("Added Course in the table.");
	}
	
	// Drop Course from the catalog
	public void dropCourse(int courseId) {
		courseCatalogDaoObject.deleteCourse(courseId);
		logger.info("Delete course from the table.");
	}
	
	// Return number of Registered Students in the particular Course
	public int numberOfRegisterdStudents(int courseId) {
		int n = courseCatalogDaoObject.numberOfRegisteredStudents(courseId);
		logger.info("Number of the students registered in course : " + courseId + " are " + n + ".");
		return n;
	}

}