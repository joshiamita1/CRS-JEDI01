package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;


public interface CourseCatalogDao {
	// Get Course by Id
	public Course getCourse(int courseId);
	
<<<<<<< HEAD
	/**
	 * Add a course to existing course list
	 * @param course
	 * @returnTpye void
	 */
	public void addCourse(Course course);
	
	/**
	 * Delete a course
	 * @param courseCode
	 * @returnType void
	 */
	public void deleteCourse(String courseCode);
	
	/**
	 * Modify a course
	 * @param courseCode
	 * @param course
	 * @returnType void
	 */
	public void modifyCourse(String courseCode, Course course);
	
	/**
	 * Get a list of all courses
	 * @returnType List<String>
	 */
	public List<String> getCourses();
	
	/**
	 * 
	 * @param courseCode
	 * @returnType Map<String,Grade>
	 */
	public Map<String, Grade> viewGrades(String courseCode);
	
	/**
	 * Get information about a course
	 * @param courseCode
	 * @returnType Course
	 */
	public Course getCourse(String courseCode);
}
=======
	// Assign Professor To the Course
	public void assignProfessor(int courseId, int professorId);
	
	// Get Id of all the courses
	public ArrayList<Integer> getCourses();
	
	// Get all courses in the given catalog
	public ArrayList<Integer> getCoursesInCatalog(int catalogId);
	
	// Add Course 
	public void addCourse(Course c);
	
	// Delete Course
	public void deleteCourse(int courseId);
	
	// Number of Registered Students
	public int numberOfRegisteredStudents(int courseId);
	
	// Check if professor teaches particular course
	public boolean validCourseForProfessor(int professorId, int courseId);
	
	// Get courses Id for the given professor
	public ArrayList<Integer> getCoursesForProfessor(int professorId);
	
	// View Grades for students enrolled
	public Map<Integer, Grade> viewGrades(int courseId);
	
	// Check if course is valid for student
	public boolean validCourseForStudent(int studentId, int courseId);
	
	public int numberOfRegisteredCourses(int studentId);
	
}
>>>>>>> lovish
