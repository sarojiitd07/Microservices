package com.course.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

//	public Set<Course> findByStudentId(Long studentId);
//	
//	@Query("Select c.id, c.courseName from Course c inner join Student_Course sc on c.id = sc.course_id inner join Student s on sc.student_id = s.id where s.id = :id")
//	public Set<Course> findCoursesByStudentId(@Param("id") Long studentId);

}
