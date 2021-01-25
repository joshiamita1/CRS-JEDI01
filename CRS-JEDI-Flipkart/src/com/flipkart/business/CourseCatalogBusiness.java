package com.flipkart.business;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

//   CourseCatalogBusiness  Class

public class CourseCatalogBusiness{ 

	private static CourseCatalogBusiness instance = null;
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	
	private CourseCatalogBusiness() {
		
	}
	
	public static CourseCatalogBusiness getInstance() {
		if(instance==null) {
			instance = new CourseCatalogBusiness();
		}
		return instance;
	}
	
	public void viewAllCourses() {   
		//ArrayList<Integer> coursesList = courseCatalogDaoObject.getCourses();
		logger.info("Course Id\tCourse Name");
//		for(Integer courseCode : coursesList) {
//			Course course = courseCatalogDaoObject.getCourse(courseCode);
//			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
//		}

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
	
	public void addCourse(Course c) {
		courseCatalogDaoObject.addCourse(c);
		logger.info("Added Course in the table.");
	}
	
	public void dropCourse(int catalogId) {
		courseCatalogDaoObject.deleteCourse(catalogId);
		logger.info("Delete course from the table.");
	}

	public int numberOfRegisterdStudents(int courseId) {
		int n = courseCatalogDaoObject.numberOfRegisteredStudents(courseId);
		logger.info("Number of the students registered in course : " + courseId + " are " + n + ".");
		return n;
	}

}