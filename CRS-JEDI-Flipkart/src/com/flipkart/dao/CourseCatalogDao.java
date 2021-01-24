package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;


public interface CourseCatalogDao {
	
	// Add course
	public void addCourse(Course course);
	
	// Delete course
	public void deleteCourse(String courseCode);
	
	// Modify course
	public void modifyCourse(String courseCode, Course course);
	
	// Get all courses
	public ArrayList<Integer> getCourses();
	
	// View Grades
	public Map<String, Grade> viewGrades(String courseCode);
	
	// Get Course Info
	public Course getCourse(String courseCode);

	Course getCourse(int courseId);

	Map<Integer, Grade> viewGrades(int courseId);
}
