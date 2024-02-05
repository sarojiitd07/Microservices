package com.student.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.School;
import com.student.repository.SchoolRepository;
import com.student.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Override
	public School getSchool(Long schoolId) {
		Optional<School> school = schoolRepository.findById(schoolId);
		if(school.isEmpty()) {
			throw new RuntimeException("School doesn't exist");
		}else {
			return school.get();
		}
	}

	@Override
	public School createSchool(School school) {
		School save = schoolRepository.save(school);
		return save;
	}

	@Override
	public School updateSchool(School school) {
		School save = schoolRepository.save(school);
		return save;
	}

	@Override
	public String deleteSchool(Long SchoolId) {
		schoolRepository.deleteById(SchoolId);
		return "delete successFully";
	}

	@Override
	public List<School> getAllSchool() {
		List<School> allSchool = schoolRepository.findAll();
		return allSchool;
	}

	@Override
	public Long studentsCount(Long schoolId) {
		Optional<School> school = schoolRepository.findById(schoolId);
		if(school.isEmpty()) {
			throw new RuntimeException("School doesn't exist");
		}else {
			long studentCount = school.get().getStudents().stream().count();
			return studentCount;
		}
	}

}
