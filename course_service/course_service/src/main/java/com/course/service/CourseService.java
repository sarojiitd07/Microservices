package com.course.service;

import java.util.List;
import java.util.Set;

import com.course.entity.Course;

public interface CourseService {
//  public Set<Course> getCourses(Long studentId);
  
  public Course getCourse(Long id);
  
  public Course createCourse(Course course);
  
  public Course updateCourse(Course course);
  
  public String deleteCourse(Long id);
  
  public List<Course> getAllCourses();
}
