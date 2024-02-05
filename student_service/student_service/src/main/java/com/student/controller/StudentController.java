package com.student.controller;

import java.util.HashSet;
import java.util.Iterator;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.model.CourseModel;
import com.student.model.StudentModel;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentModel> getStudent(@PathVariable Long id) throws JsonMappingException, JsonProcessingException{
		Student student = studentService.getStudent(id);
//		Set<Course> cources = this.restTemplate.getForObject("http://COURSE-SERVICE/course/"+id,Set.class);
		Set<Course> cources =student.getCourses();
		Set<CourseModel> modifiedCRC= new HashSet<>();
//		Gson gson = new Gson();
//		
//		for(int i=0;i<cources.size();i++) {
//			ObjectMapper objectMapper = new ObjectMapper();
//			String str = gson.toJson(cources.get(i));
//	        Course course = objectMapper.readValue(str, Course.class);
//			mdCRC.setId(course.getId());
//			mdCRC.setCourse(course.getCourse());
//			modifiedCRC.add(mdCRC);
//		}

		Iterator<Course> itr = cources.iterator();
		while(!itr.equals(null) & itr.hasNext()) {
			CourseModel mdCRC = new CourseModel();
			Course course = itr.next();
			mdCRC.setCourse(course.getCourseName());
			modifiedCRC.add(mdCRC);
		}
		
		StudentModel stu = new StudentModel();
		stu.setId(student.getId());
		stu.setStudentName(student.getStudentName());
		stu.setCources(modifiedCRC);
		return new ResponseEntity<StudentModel>(stu,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student student2 = studentService.createStudent(student);
		return new ResponseEntity<>(student2,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		Student student2 = studentService.createStudent(student);
		return new ResponseEntity<>(student2,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		String deleteStudent = studentService.deleteStudent(id);
		return new ResponseEntity<String>(deleteStudent,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents,HttpStatus.OK);
	}
}
