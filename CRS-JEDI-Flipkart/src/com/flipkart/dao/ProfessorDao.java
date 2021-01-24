package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;

import java.util.List;

public interface ProfessorDao {

	// Get Professor's info
	public Professor getProfessor(int professorId);
	
	void deleteProfessor(int userId);

	// Add Professor
	void addProfessor(User user, String password, Department department);
}
