package com.flipkart.RESTController;

import java.util.ArrayList;
import java.util.List;

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
import com.flipkart.bean.User;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.client.CRSProfessorClient;
import com.flipkart.constant.Role;
@Path("/admin")
public class AdminRESTAPI {
	
	private static Logger logger = Logger.getLogger(AdminRESTAPI.class);
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	ProfessorBusiness professorBusinessObject = ProfessorBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	AdminBusiness adminBusinessObject = AdminBusiness.getInstance();
	AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
	
	@GET
	@Path("/courses/catalog/{catalogId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getCoursesInCatalog(@PathParam("catalogId") int catalogId) {
		return courseCatalogBusinessObject.viewCoursesInCatalog(catalogId);
	}
	
	@GET
	@Path("/courses/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getAllCourses() {
		return courseCatalogBusinessObject.viewAllCourses();
	}
	
	@GET
	@Path("/viewUsers/{Role}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersOfSpecificRole(@PathParam("Role") String role) {
		
		List<User> userList = adminBusinessObject.getUsers(Role.valueOf(role));
		return userList;
	}
	/*
	@PUT
	@Path("/courses/assign")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String assignProfessor(int courseId, int professorId){
		adminBusinessObject.assignProfessor(courseId, professorId);
		return "SUCCESS";
	}
	
	@POST
	@Path("/user/register")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerStudent(User user) {
		authenticateBusinessObject.registerStudent(null, null);
		return Response.status(201).entity(user.toString()).build();
		
	}
	
	@DELETE
	@Path("/user/delete/{userId}")
	public Response deleteuser(@PathParam("userId") int userId) {
		adminBusinessObject.deleteUser(userId);
		return Response.status(200).entity("successfully deleted").build();
		
	}
	
	
	@POST
	@Path("/courses/add")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addcourse(Course course) {
		courseCatalogBusinessObject.addCourse(course);
		return Response.status(201).entity(course.toString()).build();
		
	}
	
	@DELETE
	@Path("/course/delete/{courseId}")
	public Response dropcourse(@PathParam("courseId") int courseId) {
		courseCatalogBusinessObject.dropCourse(courseId);
		return Response.status(200).entity("successfully deleted").build();
		
	}
	
	@PUT
	@Path("/user/student/approve")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String assignProfessor(int studentId){
		adminBusinessObject.approveStudent(studentId);
		return "SUCCESS";
	}
	*/
}
