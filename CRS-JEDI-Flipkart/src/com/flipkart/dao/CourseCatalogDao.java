package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;


public interface CourseCatalogDao {
	// Get Course by Id
	public Course getCourse(int courseId);
	

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

