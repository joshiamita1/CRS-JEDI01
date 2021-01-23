package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;
import java.util.ArrayList;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;

/**
 * @author Aditya Nahata
 *
 */
public class StudentDaoImpl implements StudentDao{
	
	public static Logger logger = Logger.getLogger(StudentDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	public static void main(String[]args) {
		StudentDaoImpl temp= new StudentDaoImpl();
		Student student = new Student("0", "parth@gmail.com", "abcd", "parth", 8306773046l,Role.STUDENT, Gender.MALE,"ECE", false,true);
		temp.viewGrades(102);
		//temp.viewRegisteredCourses(102);
		//temp.registerCourse(101, "501");
		
		//temp.dropCourse(101, "501");
		//temp.modifyStudent(101, student);
		//temp.addGrade(101, "501", Grade.B);
		
		//temp.addStudent(student);
		//Student student = temp.getStudent(102);
		//logger.info(student.getBranch());
		
	}


	@Override
	public void modifyStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {logger.info("hello" +SQLQueriesConstant.MODIFY_STUDENT_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.MODIFY_STUDENT_QUERY );
			//StudentId, Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state)
			//statement.setInt(1,Integer.valueOf(student.getUserId()));
			statement.setString(1,student.getName());
			statement.setString(2,student.getEmailId());
			statement.setLong(3,student.getMobile());
			statement.setString(4,String.valueOf(student.getGender()));
			statement.setString(5,student.getBranch());
			statement.setBoolean(6,student.isHasScholarship());
			statement.setBoolean(7,student.isApproved());
			statement.setString(8,student.getCity());
			statement.setString(9,student.getAddress());
			statement.setString(10,student.getState());
			statement.setInt(11, studentId);
			
			
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added Student sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		
	}
	
		@Override
	public Student getStudent(int studentId) {
		PreparedStatement statement = null;
		try {logger.info(SQLQueriesConstant.GET_STUDENT_DETAILS_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.GET_STUDENT_DETAILS_QUERY );
			statement.setInt(1,studentId);
			logger.info("statement is "+statement);
			ResultSet resultSet = statement.executeQuery();
			logger.info("userid is "+resultSet);
			if(resultSet.next())
			{
				int userId = resultSet.getInt("StudentID");
			System.out.println("userid is "+userId);
			String name = resultSet.getString("Name");
			String emailId = resultSet.getString("Email");
			long mobile = resultSet.getLong("mobile");
			Gender gender = Gender.valueOf(resultSet.getString("Gender"));
			String branch = resultSet.getString("branch");
			boolean hasScholarship= resultSet.getBoolean("HasScholarship");
			boolean isApproved= resultSet.getBoolean("IsApproved");
			Student student = new Student(Integer.toString(userId), emailId, "abcd", name, mobile,Role.STUDENT, gender,branch, hasScholarship, isApproved);
			return student;
			}
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();;
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudent(Student student) {
		PreparedStatement statement = null;
		try {logger.info("hello" +SQLQueriesConstant.ADD_STUDENT_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.ADD_STUDENT_QUERY );
			//StudentId, Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state)
			//statement.setInt(1,Integer.valueOf(student.getUserId()));
			statement.setString(1,student.getName());
			statement.setString(2,student.getEmailId());
			statement.setLong(3,student.getMobile());
			statement.setString(4,String.valueOf(student.getGender()));
			statement.setString(5,student.getBranch());
			statement.setBoolean(6,student.isHasScholarship());
			statement.setBoolean(7,student.isApproved());
			statement.setString(8,student.getCity());
			statement.setString(9,student.getAddress());
			statement.setString(10,student.getState());
			
			
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added Student sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGrade(int studentId, String courseCode, Grade grade) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {logger.info("hello" +SQLQueriesConstant.ADD_GRADE_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.ADD_GRADE_QUERY );
			
			statement.setString(1,String.valueOf(grade));
			statement.setInt(2,studentId);
			statement.setInt(3,Integer.valueOf(courseCode));
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added to Registered Course sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	
	@Override
	public void registerCourse(int studentId, String courseId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.ADD_REGISTERED_COURSE_STUDENT_QUERY );
			//StudentId, Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state)
			//statement.setInt(1,Integer.valueOf(student.getUserId()));
			statement.setInt(1,studentId);
			statement.setInt(2,Integer.valueOf(courseId));
					
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added to Registered Course sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropCourse(int studentId, String courseId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {logger.info("hello" +SQLQueriesConstant.DROP_COURSE_STUDENT_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.DROP_COURSE_STUDENT_QUERY );
			//StudentId, Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state)
			//statement.setInt(1,Integer.valueOf(student.getUserId()));
			statement.setInt(1,studentId);
			statement.setInt(2,Integer.valueOf(courseId));
					
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Dropped Course sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		
	}

	@Override
	public ArrayList<Integer> viewRegisteredCourses(int studentId) {
		PreparedStatement statement = null;
		try {logger.info(SQLQueriesConstant.GET_REGISTERED_COURSES_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.GET_REGISTERED_COURSES_QUERY );
			statement.setInt(1,studentId);
			logger.info("statement is "+statement);
			ArrayList<Integer> courselist = new ArrayList<Integer>();
			ResultSet resultSet = statement.executeQuery();
			logger.info("userid is "+resultSet);
			while(resultSet.next())
			{
				logger.info(resultSet.getString("CourseName"));
				courselist.add(resultSet.getInt("CourseId"));
			}
			return courselist;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public Map<String, Grade> viewGrades(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {logger.info(SQLQueriesConstant.VIEW_GRADES_QUERY );
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_GRADES_QUERY );
			statement.setInt(1,studentId);
			logger.info("statement is "+statement);
			Map<String, Grade> grades = new HashMap<String, Grade>();
			ResultSet resultSet = statement.executeQuery();
			logger.info("userid is "+resultSet);
			while(resultSet.next())
			{
				logger.info(resultSet.getInt("CourseId")+resultSet.getString("Grade"));
				grades.put(String.valueOf(resultSet.getInt("CourseId")),Grade.valueOf(resultSet.getString("Grade")));
			}
			logger.info(grades.get("501"));
			return grades;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
}