package com.flipkart.dao;
import java.util.*;
import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
public class CourseCatalogDaoImpl  implements CourseCatalogDao{

	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignProfessor(int courseId, int professorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numberOfRegisteredStudents(int courseId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getCoursesInCatalog(int catalogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validCourseForProfessor(int professorId, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Integer> getCoursesForProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Grade> viewGrades(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
		
			
}

  