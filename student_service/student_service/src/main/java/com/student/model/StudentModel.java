package com.student.model;

import java.util.Set;


public class StudentModel {
	private Long id;
	private String studentName;
	private Set<CourseModel> cources;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Set<CourseModel> getCources() {
		return cources;
	}
	public void setCources(Set<CourseModel> cources) {
		this.cources = cources;
	}
}
