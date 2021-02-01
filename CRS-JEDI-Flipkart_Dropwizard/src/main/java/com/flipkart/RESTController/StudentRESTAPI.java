package com.flipkart.RESTController;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Grade;
import com.flipkart.dao.UserDaoImpl;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
@Path("/student")
public class StudentRESTAPI {

	/**
	 * Business Objects
	 */
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	private static Logger logger = Logger.getLogger(StudentRESTAPI.class);
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
	
	@POST
	@Path("/courses/register/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourse( Course course, @PathParam("studentId") int studentId) {
		studentBusinessObject.registerCourse(studentId, course.getCourseCode());
		return Response.status(201).entity("Registered to courseId: "+course.getCourseCode()+ " Successfully").build();
	}
	
	@DELETE
	@Path("/courses/drop/{studentId}/{courseId}")
	public Response deleteCustomer(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
		studentBusinessObject.dropCourse(studentId, courseId);
		return Response.status(200).entity("successfully deleted").build();
		
	}
	
	@PUT
	@Path("/payFees/{studentId}/{choice}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String payFees(@PathParam("studentId")int studentId,@PathParam("choice")int choice){
		//logger.info(student.getUserId()+ choice);
		studentBusinessObject.makePayment(studentId, studentBusinessObject.getFees(studentId), choice);
		
		return "Fee Payment for student ID:"+ studentId + "Successful";
	}
	/*
	@PUT
	@Path("/testing")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String payFeestemp(JSONObject obj) throws JsonParseException, JsonMappingException, IOException{
		JSONObject jo =  obj;
		Student student;
		int choice;
		choice = (int) jo.get("choice");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		student=objectMapper.convertValue(jo.get("student"),Student.class);
		
		
		//studentBusinessObject.makePayment(studentId, studentBusinessObject.getFees(studentId), choice);
		
		return "Fee Payment for student ID:"+ student.getUserId() + "Successful"+ choice;
	}
	*/
}
