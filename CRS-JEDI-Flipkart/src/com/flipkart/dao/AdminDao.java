package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;



// Interface for admin dao 
public interface AdminDao {
	
	public ArrayList<User> viewUsers();
	public void assignProfessor(Professor professor, int courseId);
	public String addNewCourseInCatalog(Course course);
	public void deleteUser(int userId);
}
