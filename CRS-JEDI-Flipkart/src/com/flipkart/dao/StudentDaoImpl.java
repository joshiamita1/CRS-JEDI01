package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCourse(int studentId, Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Course> viewRegisteredCourses(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Course, Grade> viewGrades(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
