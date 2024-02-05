package com.student.service;

import java.util.List;

import com.student.entity.Student;


public interface StudentService {
	
	public Student getStudent(Long studentId);
	
	public Student createStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public String deleteStudent(Long studentId);
	
	public List<Student> getAllStudents();
}
