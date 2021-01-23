package com.flipkart.dao;

import com.flipkart.bean.Professor;

import java.util.List;

public interface ProfessorDao {
	
	/**
	 * Add a professor to the list of existing professors
	 * @param professor
	 * @returnType void
	 */
	public void addProfessor(Professor professor);
	
	/**
	 * Delete a professor
	 * @param professorId
	 * @returnType void
	 */
	public void deleteProfessor(String professorId);
	
	/**
	 * Get list of all professors
	 * @return
	 * @returnType List<String>
	 */
	public List<String> getProfessors();
	
	/**
	 * get details of a particular professor from the id
	 * @param professorId
	 * @return
	 * @returnType Professor
	 */
	public Professor getProfessor(String professorId);
}
