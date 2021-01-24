package com.flipkart.exception;

public class CourseNotFoundException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	String courseId;

	// Constructor to initialize courseName
	public CourseNotFoundException(String courseId) {
		
		super();
		this.courseId = courseId;
	}


	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

}