package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.*;


public interface CourseCatalogDao {
	
	// Add course
	public void addCourse(Course course);
	
	// Delete course
	public void deleteCourse(String courseCode);
	
	// Modify course
	public void modifyCourse(String courseCode, Course course);
	
	// Get all courses
	public List<String> getCourses();
	
	// Get Course Info
	public Course getCourse(String courseCode);
	
	// Add 
	public void addRegisteredStudent(String courseCode, Student student);
}
