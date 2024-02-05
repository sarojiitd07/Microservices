package com.student.controller;

import java.util.List;

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

import com.student.entity.School;
import com.student.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/{schoolId}")
	public ResponseEntity<School> getSchool(@PathVariable Long schoolId){
		School school = schoolService.getSchool(schoolId);
		return new ResponseEntity<>(school,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<School> createSchool(@RequestBody School school){
		School school2 = schoolService.createSchool(school);
		return new ResponseEntity<>(school2,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<School> updateSchool(@RequestBody School school){
		School school2 = schoolService.updateSchool(school);
		return new ResponseEntity<>(school2,HttpStatus.OK);
	}
	
	@DeleteMapping("/{schoolId}")
	public ResponseEntity<String> deleteSchool(@PathVariable Long schoolId){
		String deleteSchool = schoolService.deleteSchool(schoolId);
		return new ResponseEntity<>(deleteSchool,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<School>> getAllSchool(){
		List<School> getAllSchool = schoolService.getAllSchool();
		return new ResponseEntity<>(getAllSchool,HttpStatus.OK);
	}
	
	@GetMapping("/studentcount/{schoolId}")
	public ResponseEntity<Long> getStudentCount(@PathVariable Long schoolId){
		Long studentsCount = schoolService.studentsCount(schoolId);
		return new ResponseEntity<>(studentsCount,HttpStatus.OK);
	}
}
