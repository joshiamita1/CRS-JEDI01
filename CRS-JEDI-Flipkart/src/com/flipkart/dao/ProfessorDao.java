package com.flipkart.dao;

import com.flipkart.bean.Professor;

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
}
