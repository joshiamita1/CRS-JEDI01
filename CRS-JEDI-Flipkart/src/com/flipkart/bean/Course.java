package com.flipkart.bean;



public class Course {
	// Course code
	int courseCode;
	
	// Course name
	String courseName;
	
	
	// Catalog Id of the course
	int catalogId;
	
	// Professor of the course
	int professorId;

	public Course(int courseCode, String courseName, int catalogId, int professorId) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.catalogId = catalogId;
		this.professorId = professorId;
	}

	/**
	 * @return the courseCode
	 */
	public int getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the catalogId
	 */
	public int getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	
	
}
