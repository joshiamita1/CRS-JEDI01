
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
	// Getting all the CourseInformation of a particular course 
	public Course getCourse(String courseCode) {
		Course course = courseCatalogDaoObject.getCourse(courseCode);
		logger.info(" Course Code" +  course.getCourseCode() +  "Course Name"+  "\t\t " + course.getCourseName());
		return course;
	}

=======
package com.flipkart.business;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDaoImpl;


/**
 * @author JEDI01
 *
 */
public class CourseCatalogBusiness{ 

	/**
	 * Singleton Field
	 */
	private static CourseCatalogBusiness instance = null;
	
	
	/**
	 *  Dao Objects
	 */
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	

	/**
	 * Private Constructor
	 */
	private CourseCatalogBusiness() {
		
	}
	
	/**
	 * @return Instance of the class
	 */
	public static CourseCatalogBusiness getInstance() {
		if(instance==null) {
			instance = new CourseCatalogBusiness();
		}
		return instance;
	}
	
	/**
	 * View all courses
	 */
	public void viewAllCourses() {   
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCourses();
		logger.info("Course Id\tCourse Name");
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
		}
	}
	
	/**
	 * @param catalogId
	 * Courses in particular Catalog
	 */
	public void viewCoursesInCatalog(int catalogId) {
		
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesInCatalog(catalogId);
		
		logger.info("Course Id\tCourse Name");
		
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(course.getCourseCode() +  "\t\t " + course.getCourseName());
		}
		
	}
	
	/**
	 * @param course
	 * Add Course to the Catalog
	 */
	public void addCourse(Course course) {
		courseCatalogDaoObject.addCourse(course);
	}
	
	/**
	 * @param courseId
	 * Drop Course from the catalog
	 */
	public void dropCourse(int courseId) {
		courseCatalogDaoObject.deleteCourse(courseId);
		logger.info("Delete course from the table.");
	}

	
	/**
	 * @param courseId
	 * @return number of Registered Students in the particular Course
	 */
	public int numberOfRegisterdStudents(int courseId) {
		int n = courseCatalogDaoObject.numberOfRegisteredStudents(courseId);
		logger.info("Number of the students registered in course : " + courseId + " are " + n + ".");
		return n;
	}

}