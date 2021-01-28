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
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.client.CRSProfessorClient;
@Path("/professor")
public class ProfessorRESTAPI {
	
	
	
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	ProfessorBusiness professorBusinessObject = ProfessorBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
		//think this might be same as student
		@GET
		@Path("/courses/all")
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Course> getAllCourses() {
			return courseCatalogBusinessObject.viewAllCourses();
		}
		
		@GET
		@Path("/courses/assigned/{professorId}")
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Course> getAssignedCourses(@PathParam("professorId") int professorId) {
			return professorBusinessObject.viewAssignedCourses( professorId);
		}

		@GET
		@Path("/viewStudents/{professorId}/{courseId}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Student> viewStudents(@PathParam("professorId") int professorId,@PathParam("courseId") int courseId) {
			if(professorBusinessObject.validCourseForProfessor(professorId, courseId)) {
				return professorBusinessObject.viewRegisteredStudents(courseId);
			} else {
				//logger.info("This Course is not taught by you!");
				return null;
			}
		}
}


