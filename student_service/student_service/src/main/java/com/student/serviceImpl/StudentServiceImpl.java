package com.student.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;

	@Override
	public Student getStudent(Long studentId) {
		Optional<Student> student = repo.findById(studentId);
		if(student.isEmpty()) {
			throw new RuntimeException("Object doesn't exist");
		}else {
			return student.get();
		}
	}

	@Override
	public Student createStudent(Student student) {
		Student st = repo.save(student);
		return st;
	}

	@Override
	public Student updateStudent(Student student) {
		Student st = repo.save(student);
		return st;
	}

	@Override
	public String deleteStudent(Long studentId) {
		repo.deleteById(studentId);
		return "Delete successfully";
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> allStudents = repo.findAll();
		return allStudents;
	}
	
}
