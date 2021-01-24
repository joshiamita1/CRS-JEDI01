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
			stmt.setInt(1,course.getCourseCode());
			stmt.setString(2,course.getCourseName());
			stmt.setObject(3,null);
			stmt.setInt(4,course.getProfessorId());
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
	public void deleteCourse(int courseCode) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_COURSE_QUERY);
			stmt.setInt(1,courseCode);
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
	public void modifyCourse(int courseCode, Course course) {
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.UPDATE_COURSE_QUERY);
			stmt.setInt(1,course.getProfessorId());
			stmt.setString(2,course.getCourseName());
			stmt.setInt(3,courseCode);
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
	public ArrayList<Integer> getCourses() {
		
		PreparedStatement statement = null;
		ArrayList<Integer> newListCourses = new ArrayList<Integer>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSEID_QUERY);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int courseId = resultSet.getInt("CourseId");
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
	public Course getCourse(int courseCode) {
		
		PreparedStatement statement = null;
		Course course = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSE_QUERY);
			statement.setInt(1,courseCode);
			resultSet = statement.executeQuery();
			int courseId=0,professorId = 0, catalogId = 0;
			String  courseName = null;
			while(resultSet.next()) {
				courseId = resultSet.getInt("CourseId");
				courseName = resultSet.getString("courseName");
				professorId = resultSet.getInt("ProfessorId");
				catalogId = resultSet.getInt("CatalogId");	
			}
			course = new Course (courseCode, courseName, catalogId, professorId);
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
	public Map<Integer, Grade> viewGrades(int courseCode) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Map<Integer, Grade> courseGrades = new HashMap<Integer,Grade>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSEGRADES_QUERY);
			statement.setInt(1, courseCode);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int studentId = resultSet.getInt("StudentId");
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

	
	/**
	 * Assign a professor to a course
	 */
	@Override
	public void assignProfessor(int courseId, int professorId) {
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_COURSEPROF_QUERY);
			statement.setInt(1,professorId);
			statement.setInt(2, courseId);
			int rows = statement.executeUpdate();
			logger.info(rows + " course(s) deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				statement.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
	}


	/**
	 * Return the list of course in a course in a course catalog
	 */
	@Override
	public ArrayList<Integer> getCoursesInCatalog(int catalogId) {
		
		PreparedStatement statement = null;
		ArrayList<Integer> newListCourses = new ArrayList<Integer>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSEINCATALOG_QUERY);
			statement.setInt(1, catalogId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int courseId = resultSet.getInt("CourseId");
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
	 * Return the count of students registered to a course
	 */
	@Override
	public int numberOfRegisteredStudents(int courseId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.COUNT_REGISTERED_STUDENTS_QUERY);
			statement.setInt(1, courseId);
			resultSet = statement.executeQuery();
			int rows=0;
			while(resultSet.next()) {
				rows = resultSet.getInt("StudentCount");
			}
			return rows;
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
		return 0;
	}


	/**
	 * Check if a course is taught by a particular professor
	 */
	@Override
	public boolean validCourseForProfessor(int professorId, int courseId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_COURSE_PROF_COUNT_QUERY);
			statement.setInt(1, courseId);
			statement.setInt(2, professorId);
			resultSet = statement.executeQuery();
			int count = 0;
			while(resultSet.next()) {
				count = resultSet.getInt("pcCount");
			}
			return (count>0);
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
		return false;
	}


	/**
	 * Return the list of courses taught by a professor
	 */
	@Override
	public ArrayList<Integer> getCoursesForProfessor(int professorId) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Integer> newCourseList = new ArrayList<Integer>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_PROFESSOR_DETAIL_QUERY);
			statement.setInt(1, professorId);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int courseId = resultSet.getInt("courseId");
				newCourseList.add(courseId);
			}
			return newCourseList;
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
	 * Check if a student is registered for a course
	 */
	@Override
	public boolean validCourseForStudent(int studentId, int courseId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.CHECK_REGISTERED_COURSE_QUERY);
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			resultSet = statement.executeQuery();
			int count=0;
			while(resultSet.next()) {
				count = resultSet.getInt("CourseCount");
			}
			return (count>0);
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
		return false;
	}


	/**
	 * Return the number of courses registered by a student
	 */
	@Override
	public int numberOfRegisteredCourses(int studentId) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.COUNT_REGISTERED_COURSE_QUERY);
			statement.setInt(1, studentId);
			resultSet = statement.executeQuery();
			int count=0;
			while(resultSet.next()) {
				count = resultSet.getInt("CourseCount");
			}
			return (count);
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
		return 0;
	}		
}