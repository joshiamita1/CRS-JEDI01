/**
 * 
 */
package com.flipkart.constant;

/**
 * @author ABHI SHREE JAIN
 *
 */

public class SQLQueriesConstant{
	
	//Login query for a user
	public static String LOGIN_QUERY = "SELECT r.role from Role r join  user u on r.roleId = u.roleId where username = ? and password = ?";
	public static String GET_ROLE_ID_QUERY = "select roleId from role where role = ?";
	
	public static String GET_USER_DETAIL = "select id from authorcredential ";
	public static String GET_USER_DETAIL_ROLE = "select id from authorcredential where role = ?";
	public static String DELETE_USER_QUERY = "delete from authorcredential where userId = ? ";
	public static String GET_USER_DETAIL_ID = "select username, password, role from authorcredential where id = ?";
	
	//NotificationSystem
	public static String NOTIFICATION_QUERY="insert into notificationsystem (UserID , Message, TimeNotified) values (?, ?,?)";
	// View Courses
	public static String VIEW_CATALOG_QUERY = "select courseId, courseName, fees, courseDescription from Course";
	public static String VIEW_COURSE_QUERY = "select * from Course where courseId = ?";
	
	// Student Queries
	public static String MODIFY_STUDENT_QUERY ="update Student  set Name = ?,Email = ?,Mobile = ?,Gender = ?, branch = ?, hasScholarship = ?, isApproved = ?,city = ?, address = ?,state = ?  where studentId=?";
	public static String GET_STUDENT_DETAILS_QUERY = "select * from student where StudentID=?";
	public static String ADD_STUDENT_QUERY = "insert into Student (Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state) values (?,?,?,?,?,?,?,?,?,?)";
	public static String ADD_REGISTERED_COURSE_STUDENT_QUERY = "insert into RegisteredCourse (studentId, courseId) values(?,?)";
	public static String ADD_GRADE_QUERY = "update RegisteredCourse set grade=? where studentid = ? and courseID =? limit 1";
	public static String DROP_COURSE_STUDENT_QUERY = "delete from RegisteredCourse where  studentId = ? and courseId = ? ";
	public static String GET_REGISTERED_COURSES_QUERY = "select rc.studentId, rc.courseId,cc.CourseName from RegisteredCourse as rc inner join coursecatalog as cc on rc.courseID =cc.CourseCode where rc.studentId = ?";
	public static String VIEW_GRADES_QUERY = "select * from RegisteredCourse where studentId = ?";
	public static String COUNT_COURSE= "select count(CourseId) as coursecount from RegisteredCourse where studentId = ?";
	public static String UPDATE_FEE="update Student set AmountPayable = ? where studentId=?";
	public static String MAKE_PAYMENT_QUERY = "insert into Payment(studentId, AmountPaid,DateofPayment) values(?, ?, ?)";
	public static String GET_FEE_QUERY="select amountPayable from student where StudentId= ?";
	/*
	public static String COUNT_REGISTERED_COURSES_QUERY = "select count(*) from RegisteredCourses where studentId = ?";
	public static String CHECK_IF_REGISTERED_TO_COURSE_QUERY = "select count(*) from RegisteredCourses where studentId = ? and courseId = ?";
	public static String GET_STUDENT_NAME_QUERY = "select * from Student where studentId = ?";
	public static String VIEW_GRADES_QUERY = "select c.courseId, c.courseName, rc.grade from Course c join RegisteredCourses rc on rc.courseId = c.courseId where rc.studentId = ?";
	 
	public static String MAKE_PAYMENT_QUERY = "insert into Payment(studentId, feesPaid, paymentMethodId, paymentDate) values(?, ?, ?, ?)";
	public static String UPDATE_AFTER_PAYMENT = "update Student set isRegistered = 1 where studentId = ?";
	*/
	// Professor Queries
	public static String REGISTER_PROFESSOR_QUERY = "insert into Professor(professorId, professorName, gender) values (?,?,?)";
	public static String GET_PROFESSOR_DETAILS_QUERY = "select professorId, professorName, gender from Professor where professorName = ?";
	public static String GET_STUDENT_IDS_FOR_COURSE_QUERY = "select studentId from RegisteredCourses where courseId = ?";
	public static String GET_COURSE_TAUGHT_BY_PROFESSOR = "select p.courseId, c.courseName, c.courseDescription from ProfessorCourse p join Course c on c.courseId = p.courseId where p.professorId = ?";
	public static String GET_STUDENTS_TAUGHT = "select rc.studentId, rc.courseId, s.studentName, s.branch, s.gender, s.semester from Student s join RegisteredCourses rc on rc.studentId = s.studentId where rc.courseId in (select courseId from ProfessorCourse where professorId = ?) order by rc.courseId";
	public static String VALID_COURSE_FOR_PROFESSOR = "select count(*) from ProfessorCourse where professorId = ? and courseId = ?";
	public static String GRADE_STUDENT_QUERY = "update RegisteredCourses set grade = ? where studentId = ? and courseId = ?";
	public static String VALID_STUDENT_COURSE = "select count(*) from RegisteredCourses where studentId = ? and courseId = ?";
	
	public static String VIEW_PROFESSORID_QUERY = "select id from Professor";
	public static String DELETE_PROF_QUERY = "delete from professor where professorId = ? ";
	public static String GET_PROF_DETAIL = "select p.professorId, p.dept, p.gender, p.emailId, a.userName, a.password, p.mobile, a.role, p.gender from professor p join authorcredential a on p.professorId = a.id ";
	public static String ADD_NEW_USER_QUERY = "insert into authorcredential(username, password, role, id) values(?,?,?,?)";
	
	// Admin Queries
	public static String REGISTER_ADMIN_QUERY = "insert into Admin(adminId, adminName, gender) values(?,?,?)";
	public static String VIEW_USERS_QUERY = "SELECT  u.userId, u.username, r.role from user u join Role r on r.roleId = u.roleId;";
	public static String UPDATE_COURSE_PROFESSOR_QUERY = "update Course SET professor=? WHERE courseId = ?";
	public static String ADD_NEW_COURSE_QUERY = "insert into Course(courseId, courseName, fees, courseDescription, catalogId) values (?,?, ?, ?, ?)";
	public static String DELETE_COURSE_QUERY = "delete from Course where courseId = ?";
	public static String REGISTER_USER_QUERY = "insert into user(UserId, username, password, roleId) values (?,?,?,?)";
	public static String ASSIGN_PROFESSOR_QUERY = "insert into ProfessorCourse(courseId, professorId) values (?, ?)";
	
	public static String DELETE_ADMIN_QUERY = "delete from admin where adminId = ? ";
	
	//
}