package com.course.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.student.entity.School;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="student_course", joinColumns = {@JoinColumn(name="student_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="course_id", referencedColumnName = "id")})
//	@JsonManagedReference
	private Set<Course> courses;
	
	@ManyToOne()
	@JsonIgnore
	private School school;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String studentName, Set<Course> courses) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.courses = courses;
//		this.school = school;
	}

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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
//
//	public School getSchool() {
//		return school;
//	}
//
//	public void setSchool(School school) {
//		this.school = school;
//	}

}
