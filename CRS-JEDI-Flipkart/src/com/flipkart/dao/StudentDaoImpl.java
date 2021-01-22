package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void modifyStudent(String studentId, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudent(String studentId) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGrade(String studentId, String courseCode, Grade grade) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void registerCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> viewRegisteredCourses(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Grade> viewGrades(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
