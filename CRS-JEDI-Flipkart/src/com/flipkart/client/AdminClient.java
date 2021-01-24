package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class AdminClient {

	public static Logger logger = Logger.getLogger(AdminClient.class);
	Scanner sc = new Scanner(System.in);
	AdminBusiness adminBusinessObject = new AdminBusiness();
	CourseCatalogBusiness courseCatalogBusinessObject = new CourseCatalogBusiness();
	AuthenticateBusiness authenticateBusinessObject = new AuthenticateBusiness();
	public void displayMenu(int userId) {
		int choice;
		do {
			printChoices();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				viewCoursesInCatalog();
				break;
			case 2:
				courseCatalogBusinessObject.viewAllCourses();
				break;
			case 3:
				viewUsersOfSpecificRole();
				break;
			case 4:
				assignCourseToProfessor();
				break;
			case 5:
				registerUser();
				break;
			case 6:
				deleteUser();
				break;
			case 7:
				addNewCourse();
				break;
			case 8:
				dropCourse();
			case 9:
				approveStudent();
			case 0:
				break;
			default:
				logger.info("Invalid Choice./nTry Again\n");
				break;
			}
		}
		while(choice!=0);
		
	}
	
	// View Courses in particular Catalog
	public void viewCoursesInCatalog() {
		logger.info("Enter Catalog ID");
		int catalogId = sc.nextInt();
		courseCatalogBusinessObject.viewCoursesInCatalog(catalogId);
	}
	
	// View Users of the specific Role
	public void viewUsersOfSpecificRole() {
		logger.info("Enter one of the following Role (\"ADMIN\", \"PROFESSOR\", \"STUDENT\"\n");
		String role = sc.nextLine();
		adminBusinessObject.getUsers(Role.valueOf(role));
	}
	
	// Assign Course to Professor
	public void assignCourseToProfessor() {
		logger.info("Enter Course Code");
		int courseCode = sc.nextInt();
		logger.info("Enter Professor ID");
		int professorId = sc.nextInt();
		adminBusinessObject.assignProfessor(courseCode, professorId);
	}
	
	// Show available choices
	void printChoices() {
		logger.info("Enter your choice:");
		logger.info("1. To view courses in catalog");
		logger.info("2. View All Courses");
		logger.info("3. To view users of Specific Role");
		logger.info("4. Assign course to a professor");
		logger.info("5. Register a new user");
		logger.info("6. Delete a user");
		logger.info("7. Add a new course to catalog");
		logger.info("8. Drop a course from catalog");
		logger.info("9. Approve student");
		logger.info("0. To logout");
	}
	
	public void approveStudent() {
		logger.info("Enter Student ID to approve");
		int studentId = sc.nextInt();
		adminBusinessObject.approveStudent(studentId);
	}
	
	public void registerUser() {
		User user = new User();
		String password;
		logger.info("Select Role of the User (PROFESSOR, ADMIN)");
		user.setRole(Role.valueOf(sc.nextLine()));
		user.setUserId(201);
		logger.info("Enter Name");
		user.setName(sc.nextLine());
		logger.info("Enter Password");
		password = sc.nextLine();
		logger.info("Enter Email");
		user.setEmailId(sc.nextLine());
		logger.info("Enter Mobile No.");
		user.setMobile(sc.nextLong());
		logger.info("Select Gender: 'M' for male and 'F' for female");
		user.setGender(Gender.valueOf(sc.nextLine()));
		logger.info("Enter Address");
		user.setAddress(sc.nextLine());
		logger.info("Enter City");
		user.setCity(sc.nextLine());
		logger.info("Enter State");
		user.setState(sc.nextLine());
		logger.info("Enter Country");
		user.setCountry(sc.nextLine());
		switch(user.getRole()) {
		case ADMIN:
			if(authenticateBusinessObject.registerAdmin(user, password)) {
				logger.info("Registration Success\nUser id of Admin is "+user.getUserId());
			} else {
				logger.info("Please Register Again!\nRegistration Failed\n");
			}
			break;
		case PROFESSOR:
			logger.info("Enter Department");
			Department department = Department.valueOf(sc.nextLine());
			if(authenticateBusinessObject.registerProfessor(user, password, department)) {
				logger.info("Registration Success\nUser id of Professor is "+user.getUserId());
			} else {
				logger.info("Please Register Again!\nRegistration Failed\n");
			}
			break;
		default:
			break;
		}
	}
	
	public void deleteUser() {
		logger.info("Enter user ID");
		int userId = sc.nextInt();
		adminBusinessObject.deleteUser(userId);
	}
	
	public void addNewCourse() {
		int courseCode, professorId, catalogId;
		String courseName;
		logger.info("Enter Course ID");
		courseCode = sc.nextInt();
		logger.info("Enter Course Name");
		courseName = sc.nextLine();
		logger.info("Enter catalog ID");
		catalogId = sc.nextInt();
		logger.info("Enter professorId or -1 if not assigned");
		professorId = sc.nextInt();
		Course course = new Course(courseCode, courseName, catalogId, professorId);
		courseCatalogBusinessObject.addCourse(course);
	}
	
	public void dropCourse() {
		int courseId = sc.nextInt();
		courseCatalogBusinessObject.dropCourse(courseId);
	}
}
