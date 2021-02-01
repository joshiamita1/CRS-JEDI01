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
import org.json.simple.JSONObject;
import org.json.simple.JSONArray; 
 
import org.json.simple.parser.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
//import com.flipkart.client.CRSProfessorClient;
import com.flipkart.constant.Department;
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
	
	/**
	 * @body {
	 * 			professorId:
	 * 			,courseId:
	 * 		}
	 * @param obj
	 * @return
	 */
	@PUT
	@Path("/courses/assign")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignProfessor(JSONObject obj) {
		int courseId; int professorId;
		try{
			professorId=(int) obj.get("professorId");
			courseId = (int) obj.get("courseId");
		}catch(Exception e) {
			return Response.status(400).entity("Insertion not allowed, message:"+e.getMessage()).build();
		}
		adminBusinessObject.assignProfessor(courseId, professorId);
		return Response.status(201).entity("SUCCESS").build();
	}
	/**
	 * @body {
	 * 		"user":{
	 * 					//user bean class attributes
	 * 				}
	 * 		,"password":
	 * 		,//other user specific attributes 
	 * 	}
	 * @param obj
	 * @return
	 */
	 
	@POST
	@Path("/user/register")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerStudent(JSONObject obj) {
		String password;
		try{
			password = (String) obj.get("password");
		}catch(Exception e) {
			return Response.status(400).entity(" Insertion not allowed, message:"+e.getMessage()).build();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		User user=objectMapper.convertValue(obj.get("user"),User.class);
		if (user.getRole()==Role.PROFESSOR){
			try{
				String department = (String) obj.get("department");
				authenticateBusinessObject.registerProfessor(user, password, Department.valueOf(department));
			}catch(Exception e) {
			//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
			return Response.status(400).entity(" Insertion not allowed, message:"+e.getMessage()).build();
			}
			return Response.status(201).entity(user.toString()).build();
		}
		else if(user.getRole()==Role.ADMIN){
			authenticateBusinessObject.registerAdmin(user, password);
			return Response.status(201).entity(user.toString()).build();
		}
		else if(user.getRole()==Role.STUDENT) {
			Student student = new Student();
			try{
							
			student.setUserId(user.getUserId());
			student.setEmailId(user.getEmailId());
			student.setName(user.getName());
			student.setMobile(user.getMobile());
			student.setGender(user.getGender());
			student.setRole(Role.STUDENT);
			student.setAddress(user.getAddress());
			student.setCity(user.getCity());
			student.setCountry(user.getCountry());
			student.setState(user.getState());
			student.setAmountPayable(0);
			student.setHasScholarship((boolean)obj.get("isHasScholarship"));
			student.setBranch(Department.valueOf((String) obj.get("branch")));
			student.setApproved(false);}
			catch(Exception e) {
				//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
				return Response.status(400).entity(" Insertion not allowed, message:"+e.getMessage()).build();
				}
			authenticateBusinessObject.registerStudent(student, password);
			return Response.status(201).entity(user.toString()).build();
		}
		else 
			return Response.status(201).entity("registraition failed").build(); 
	}
	
	@DELETE
	@Path("/user/delete/{userId}")
	public Response deleteuser(@PathParam("userId") int userId) {
		try{
			adminBusinessObject.deleteUser(userId);
		}catch(Exception e) {
			//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
			return Response.status(400).entity("Insertion not allowed, message:"+e.getMessage()).build();
		}
		return Response.status(200).entity("successfully deleted").build();
		
	}
	
	/**
	 * @body {
	 * 			"courseCode":
	 * 			,"catalogId":
	 * 			//and other course related fields
	 * 			}
	 * @param course
	 * @return
	 */
	@POST
	@Path("/courses/add")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addcourse(Course course) {
		try{
			courseCatalogBusinessObject.addCourse(course);
		}catch(Exception e) {
			//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
			return Response.status(400).entity("Insertion not allowed, message:"+e.getMessage()).build();
		}
		return Response.status(201).entity(course.toString()).build();
		
	}

	@DELETE
	@Path("/course/delete/{courseId}")
	public Response dropcourse(@PathParam("courseId") int courseId) {
		try{
			courseCatalogBusinessObject.dropCourse(courseId);
		}catch(Exception e) {
			//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
			return Response.status(400).entity("Deletion not allowed, message:"+e.getMessage()).build();
		}
		return Response.status(200).entity("successfully deleted").build();
		
	}
	/**
	 * @body {
	 * 			"studentId":
	 * 			}
	 * @param obj
	 * @return
	 */
	@PUT
	@Path("/user/student/approve/")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(JSONObject obj){
		try{
			adminBusinessObject.approveStudent((int)obj.get("studentId"));
		}catch(Exception e) {
			//System.debug('400 Bad Request, Insertion not allowed, message:'+e.getMessage());
			return Response.status(400).entity("Insertion not allowed, message:"+e.getMessage()).build();
		}
		return Response.status(200).entity("success").build();
	}
	
}
