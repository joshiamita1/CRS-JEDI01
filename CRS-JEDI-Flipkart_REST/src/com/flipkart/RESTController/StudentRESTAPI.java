package com.flipkart.RESTController;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Grade;

@Path("/student")
public class StudentRESTAPI {

	/**
	 * Business Objects
	 */
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	private static Logger logger = Logger.getLogger(StudentBusiness.class);
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
			
	}
	
	@GET
	@Path("/courses/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getAllCourses() {
		return courseCatalogBusinessObject.viewAllCourses();
	}
	
	@GET
	@Path("viewGrade/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Grade> viewGrades(@PathParam("studentId") int studentId) {
		
		return studentBusinessObject.printReportCard(studentId);
	}
	/*
	@POST
	@Path("/courses/register/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourse(@PathParam("studentId") int studentId, int courseId) {
		studentBusinessObject.registerCourse(studentId, courseId);
		return Response.status(201).entity("ADDED Course").build();
	}
	
	@DELETE
	@Path("/courses/drop/{studentId}/{courseId}")
	public Response deleteCustomer(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
		studentBusinessObject.dropCourse(studentId, courseId);
		return Response.status(200).entity("successfully deleted").build();
		
	}

	@PUT
	@Path("/payFees")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Student payFees(int studentId){
		studentBusinessObject.makePayment(studentId, studentBusinessObject.getFees(studentId), 1);
		//return studentBusinessObject.getS
		return null;
	}
	*/
}
