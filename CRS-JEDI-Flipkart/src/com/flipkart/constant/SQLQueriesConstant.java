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
	public static String GET_USER_DETAIL = "select id from authorcredential ";
	public static String GET_USER_DETAIL_ROLE = "select id from authorcredential where role = ?";
	public static String DELETE_USER_QUERY = "delete from authorcredential where userId = ? ";
	public static String GET_USER_DETAIL_ID = "select username, password, role from authorcredential where id = ?";
	public static String ADD_NEW_USER_QUERY = "insert into authorcredential(username, password, role, id) values(?,?,?,?)";

	
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
	
	// Professor Queries
	public static String VIEW_PROFESSORID_QUERY = "select id from Professor";
	public static String DELETE_PROF_QUERY = "delete from professor where professorId = ? ";
	public static String GET_PROF_DETAIL = "select p.professorId, p.dept, p.gender, p.email, a.userName, a.password, p.mobile, a.role, p.gender from professor p join authorcredential a on p.professorId = a.id ";
	public static String ADD_NEW_PROF_QUERY = "insert into professor(professorId, dept, gender, city, address, country, state, mobile, email) values(?,?,?,?,?,?,?,?,?) ";
	
	// Admin Queries
	public static String DELETE_ADMIN_QUERY = "delete from admin where adminId = ? ";
	public static String ADD_NEW_ADMIN_QUERY = "insert into admin(adminId, gender, city, address, country, state, mobile, email) values (?,?,?,?,?,?,?,?)";

	//
}
