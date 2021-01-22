package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

public interface StudentDao {
	
	public void addStudent(Student student);
	
	//Register for a course
	public void registerCourse(String studentId, Course course);
	
	//drop a courses
	public void dropCourse(String courseId, String studentId);
	
	//Add a courses
	public void addCourse(String courseId, String studentId);
	
	//View Registered Courses
	public ArrayList<Course> viewRegisteredCourses(String string);
	
	//View Grades
	public Map<Course, Grade> viewGrades(String studentId);
	
	public int numberOfRegisteredCourse(Student student);
}
