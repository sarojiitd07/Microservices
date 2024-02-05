package com.student.service;

import java.util.List;

import com.student.entity.School;

public interface SchoolService {

	public School getSchool(Long schoolId);
	public School createSchool(School school);
	public School updateSchool(School school);
	public String deleteSchool(Long SchoolId);
	public List<School> getAllSchool();
	public Long studentsCount(Long schoolId);
}
