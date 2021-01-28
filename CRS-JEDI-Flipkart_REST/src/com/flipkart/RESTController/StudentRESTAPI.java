package com.flipkart.RESTController;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipkart.bean.Course;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;

@Path("/student")
public class StudentRESTAPI {

	/**
	 * Business Objects
	 */
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	
	/**
	 * @param studentId
	 * Check courses student already registered
	 * @return 
	 */
	@GET
	@Path("/courses/registered/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	//@PathParam("studentId") int studentId
	public ArrayList<Course> viewRegisteredCourses(@PathParam("studentId") int studentId) {
		return studentBusinessObject.viewRegisteredCourses(studentId);
		//courseCatalogBusinessObject.viewAllCourses();
		//return "asodjfsakf"+studentId;	
	}
	
	@GET
	@Path("/courses/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getAllCourses() {
		return courseCatalogBusinessObject.viewAllCourses();
	}
	
	@GET
	@Path("viewGrade/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> viewGrades(@PathParam("studentId") int studentId) {
		return null;
	}
}
