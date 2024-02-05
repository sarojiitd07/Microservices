package com.course.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Course;
import com.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

//	@GetMapping("{id}")
//	public ResponseEntity<Set<Course>> getCourses(@PathVariable Long id){
//		Set<Course> course = courseService.getCourses(id);
//		return new ResponseEntity<Set<Course>>(course,HttpStatus.OK);
//	}
//	
	@PostMapping("/create")
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		Course course2 = courseService.createCourse(course);
		return new ResponseEntity<Course>(course2,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
		Course course2 = courseService.updateCourse(course);
		return new ResponseEntity<Course>(course2,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id){
		String deleteCourse = courseService.deleteCourse(id);
		return new ResponseEntity<String>(deleteCourse,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> course = courseService.getAllCourses();
		return new ResponseEntity<List<Course>>(course,HttpStatus.OK);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id){
		System.out.println("controller");
		Course course = courseService.getCourse(id);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
}
