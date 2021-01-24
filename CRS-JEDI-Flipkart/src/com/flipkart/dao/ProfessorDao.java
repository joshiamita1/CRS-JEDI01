package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;

import java.util.List;

public interface ProfessorDao {
	
	// Add Professor
	public void addProfessor(Professor professor);
	
	// Delete Professor
	public void deleteProfessor(String professorId);
	
	// Get All Professors
	public List<String> getProfessors();
	
	// Get Professor's info
	public Professor getProfessor(String professorId);

	void deleteProfessor(int userId);

	void addProfessor(User user, String password, Department department);

	Professor getProfessor(int professorId);
}
