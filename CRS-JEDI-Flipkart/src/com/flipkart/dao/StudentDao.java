package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

public interface StudentDao {
	
	
	public void deleteStudent(int studentId);
	
	
	// Get Student
	public Student getStudent(int studentId);
	// Drop Course
	void dropCourse(int studentId, int courseId);
	// View Registered Courses
	public ArrayList<Integer> viewRegisteredCourses(int studentId);
	
	// View Grades
	public Map<Integer, Grade> viewGrades(int studentId);
	void approveStudent(int studentId);

	void addStudent(Student student, String password);

	void addGrade(int studentId, int courseId, Grade grade);
	void registerCourse(int studentId, int courseId);
	public boolean hasScholarship(int studentId);

}
