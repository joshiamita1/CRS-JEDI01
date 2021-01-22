package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

public interface StudentDao {
	// Add Student
	public void addStudent(Student student);
	
	// Modify Student
	public void modifyStudent(String studentId, Student student);
	
	// Get Student
	public Student getStudent(String studentId);
	
	// Add Grade
	public void addGrade(String studentId, String courseCode, Grade grade);
	
	// Register A Course
	public void registerCourse(String studentId, String courseId);
	
	// Drop Course
	public void dropCourse(String studentId, String courseId);
	
	// View Registered Courses
	public ArrayList<Course> viewRegisteredCourses(String studentId);
	
	// View Grades
	public Map<String, Grade> viewGrades(String studentId);
}
