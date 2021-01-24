package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.*;
import com.flipkart.constant.*;
import com.flipkart.constant.*;
import com.flipkart.util.DBUtil;

/**
 * @author surya
 *
 */
/**
 * @author surya
 *
 */
/**
 * @author surya
 *
 */
public class CourseCatalogDaoImpl  implements CourseCatalogDao{

	public static Logger logger = Logger.getLogger(CourseCatalogDaoImpl.class);
	Connection connection = DBUtil.getConnection();

	/**
	 * Add a new course into the Course Catalog table in the database
	 */
	@Override
	public void addCourse(Course course) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_COURSE_QUERY);
			stmt.setString(1,course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setObject(3,course.getCourseDescription());
			stmt.setString(4,course.getProfessorId());
			stmt.setString(5,course.getCourseName());
			int rows = stmt.executeUpdate();
			logger.info(rows + " course added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				stmt.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Delete a course from the Course Catalog table in the database
	 */
	@Override
	public void deleteCourse(String courseCode) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_COURSE_QUERY);
			stmt.setString(1,courseCode);
			int rows = stmt.executeUpdate();
			logger.info(rows + " course(s) deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				stmt.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * Modify a course in the Course Catalog table in the database
	 */
	@Override
	public void modifyCourse(String courseCode, Course course) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.UPDATE_COURSE_QUERY);
			stmt.setString(1,course.getProfessorId());
			stmt.setString(2,course.getCourseName());
			stmt.setString(3,courseCode);
			int rows = stmt.executeUpdate();
			logger.info(rows + " course(s) updated");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				stmt.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * Returns the list of existing courses in the Course Catalog table in the database
	 */
	@Override
	public ArrayList<String> getCourses() {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ArrayList<String> newListCourses = new ArrayList<String>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSEID_QUERY);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String courseId = resultSet.getString("CourseId");
				newListCourses.add(courseId);
			}
			return newListCourses;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				resultSet.close();
				statement.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *	Return a course which has the course code as the parameter specified
	 */
	@Override
	public Course getCourse(String courseCode) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Course course = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSE_QUERY);
			statement.setString(1,courseCode);
			resultSet = statement.executeQuery();
			String courseId=null, courseName = null, professorId = null, catalogId = null;
			while(resultSet.next()) {
				courseId = resultSet.getString("CourseId");
				courseName = resultSet.getString("courseName");
				professorId = resultSet.getString("ProfessorId");
				catalogId = resultSet.getString("CatalogId");	
			}
			course = new Course();
			course.setCatalogId(catalogId);
			course.setCourseCode(courseCode);
			course.setCourseName(courseName);
			course.setProfessorId(professorId);
			return course;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				resultSet.close();
				statement.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Return the student grades of the course which has course id as specified by the parameter
	 */
	@Override
	public Map<String, Grade> viewGrades(String courseCode) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Map<String, Grade> courseGrades = new HashMap<String,Grade>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSEGRADES_QUERY);
			statement.setString(1, courseCode);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String studentId = resultSet.getString("StudentId");
				Grade grade = Grade.valueOf(resultSet.getString("Grade"));
				courseGrades.put(studentId, grade);
			}
			return courseGrades;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				resultSet.close();
				statement.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
		return null;
	}		
}





