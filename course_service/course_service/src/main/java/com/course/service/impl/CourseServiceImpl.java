package com.course.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.Course;
import com.course.repository.CourseRepository;
import com.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;

//	@Override
//	public Set<Course> getCourses(Long studentId) {
//		
//		System.out.println("hello");
//		System.out.println(courseRepository.findCoursesByStudentId(studentId));
//		System.out.println("hello===================");
//		Set<Course> cources = courseRepository.findCoursesByStudentId(studentId);
//		
//		return cources;
//	}

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public String deleteCourse(Long id) {
		courseRepository.deleteById(id);
		return "Deleted Successesfully";
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourse(Long id) {
		System.out.println("impl");
		Optional<Course> course = courseRepository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course doesn't exist");
		}else {
			return course.get();
		}
	}

}
