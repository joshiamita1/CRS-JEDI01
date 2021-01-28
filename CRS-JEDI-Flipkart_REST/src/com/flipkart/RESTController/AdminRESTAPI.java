package com.flipkart.RESTController;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.AdminBusiness;
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
}
