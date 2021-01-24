/**
 * 
 */
package com.flipkart.constant;

/**
 * @author ABHI SHREE JAIN
 *
 */

public class SQLQueriesConstant{
	
	//General Queries
	public static String GET_LAST_ENTRY = " SELECT ID from authorcredential order by ID desc limit 1  ";
	
	//Login query for a user
	public static String GET_USER_DETAIL = "select id from authorcredential ";
	public static String GET_USER_DETAIL_ROLE = "select id from authorcredential where role = ?";
	public static String DELETE_USER_QUERY = "delete from authorcredential where userId = ? ";
	public static String GET_USER_DETAIL_ID = "select username, password, role from authorcredential where id = ?";
	public static String ADD_NEW_USER_QUERY = "insert into authorcredential(username, password, role) values(?,?,?)";
	public static String MODIFY_USER_QUERY ="update authorcredential  set username = ?,role = ?  where userId=?";
	
	//NotificationSystem
	public static String NOTIFICATION_QUERY="insert into notificationsystem (UserID , Message, TimeNotified) values (?, ?,?)";
	
	// View Courses
	public static String VIEW_COURSE_QUERY = "select * from Course";
	public static String VIEW_COURSEID_QUERY = "select courseId from Course";
	public static String VIEW_COURSE_PROF_COUNT_QUERY = "select count(*) as pcCount from Course where courseId=? AND ProfessorId=?";
	public static String VIEW_PROFESSOR_DETAIL_QUERY = "select * from Course where ProfessorId=?";
	public static String VIEW_COURSEINCATALOG_QUERY = "select courseId from Course where CatalogId=?";
	public static String ADD_NEW_COURSE_QUERY = "insert into Course(CatalogID, courseId, CatalogDetail, ProfessorId, courseName) values (?, ?, ?, ?, ?)";
	public static String VIEW_COURSEGRADES_QUERY = "select * from RegisteredCourses where CourseId=?";
	public static String DELETE_COURSE_QUERY = "delete from Course where CourseId = ? ";
	public static String UPDATE_COURSE_QUERY = "update Course SET ProfessorId=?, courseName=? WHERE courseId = ?";
	public static String UPDATE_COURSEPROF_QUERY = "update Course SET ProfessorId=? WHERE courseId = ?";
	public static String COUNT_REGISTERED_STUDENTS_QUERY = "select count(*) as StudentCount from RegisteredCourses where (CourseId = ?)";
	public static String CHECK_REGISTERED_COURSE_QUERY = "select count(*) as CourseCount from RegisteredCourses where (StudentId = ? AND CourseId = ?)";
	public static String COUNT_REGISTERED_COURSE_QUERY = "select count(*) as CourseCount from RegisteredCourses where (StudentId = ?)";
	
	// Student Queries
	public static String MODIFY_STUDENT_QUERY ="update Student  set Name = ?,EmailId	 = ?,Mobile = ?,Gender = ?, branch = ?, hasScholarship = ?, isApproved = ?,city = ?, address = ?,state = ?  where studentId=?";
	public static String GET_STUDENT_DETAILS_QUERY = "select * from student where StudentID=?";
	public static String ADD_STUDENT_QUERY = "insert into Student (StudentID,Name,EmailId,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state) values (?,?,?,?,?,?,?,?,?,?,?)";
	public static String ADD_REGISTERED_COURSE_STUDENT_QUERY = "insert into RegisteredCourse (studentId, courseId) values(?,?)";
	public static String ADD_GRADE_QUERY = "update RegisteredCourse set grade=? where studentid = ? and courseID =? limit 1";
	public static String DROP_COURSE_STUDENT_QUERY = "delete from RegisteredCourse where  studentId = ? and courseId = ? ";
	public static String GET_REGISTERED_COURSES_QUERY = "select rc.studentId, rc.courseId,cc.CourseName from RegisteredCourse as rc inner join coursecatalog as cc on rc.courseID =cc.CourseCode where rc.studentId = ?";
	public static String VIEW_GRADES_QUERY = "select * from RegisteredCourse where studentId = ?";
	public static String COUNT_COURSE= "select count(CourseId) as coursecount from RegisteredCourse where studentId = ?";
	public static String UPDATE_FEE="update Student set AmountPayable = ? where studentId=?";
	public static String MAKE_PAYMENT_QUERY = "insert into Payment(studentId, AmountPaid,DateofPayment) values(?, ?, ?)";
	public static String GET_FEE_QUERY="select amountPayable from student where StudentId= ?";
	public static String GET_HAS_SCHOLARSHIP =" select HasScholarship from student where StudentID= ?";
	public static String APPROVE_STUDENT_QUERY="update Student set isApproved =? where studentID= ?";
	public static String DELETE_STUDENT_QUERY = "delete from student where studentId = ? ";
	// Professor Queries
	public static String VIEW_PROFESSORID_QUERY = "select ProfessorId from Professor";
	public static String DELETE_PROF_QUERY = "delete from professor where professorId = ? ";
	public static String GET_PROF_DETAIL = "select p.professorId, p.dept, p.gender, p.email, p.Name, p.mobile, p.gender from professor where p.professorId =? ";
	public static String ADD_NEW_PROF_QUERY = "insert into professor(professorId, dept, gender, city, address, country, state, mobile, email) values(?,?,?,?,?,?,?,?,?) ";
	
	// Admin Queries
	public static String DELETE_ADMIN_QUERY = "delete from admin where adminId = ? ";
	public static String ADD_NEW_ADMIN_QUERY = "insert into admin(adminId, gender, city, address, country, state, mobile, email) values (?,?,?,?,?,?,?,?)";

	//
}

