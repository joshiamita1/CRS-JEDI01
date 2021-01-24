package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

public interface StudentDao {
	// Add Student
	public void addStudent(Student student);
	
	// Modify Student
	public void modifyStudent(int studentId, Student student);
	
	public void deleteStudent(int studentId);
	// Get Student
	public Student getStudent(int studentId);
	
	// Add Grade
	public void addGrade(int studentId, String courseCode, Grade grade);
	
	// Register A Course
	public void registerCourse(int studentId, String courseId);
	
	// Drop Course
	public void dropCourse(int studentId, String courseId);
	
	// View Registered Courses
	public ArrayList<Integer> viewRegisteredCourses(int studentId);
	
	// View Grades
	public Map<String, Grade> viewGrades(int studentId);
}
