package com.course.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String schoolName;
	private String schoolAddress;
	
	@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinColumn(name="school_id", referencedColumnName = "id")
	List<Student> students;

	public School() {
		super();
	}

	public School(Long id, String schoolName, String schoolAddress, List<Student> students) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
