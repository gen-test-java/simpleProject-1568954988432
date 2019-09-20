package com.test.serviceImpl;

import org.springframework.stereotype.Service;
import com.test.repository.StudentResourceRepository;
import com.test.entity.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.services.StudentResourceService;
import java.lang.Long;
import java.util.List;

@Service
public class StudentResourceServiceImpl implements StudentResourceService {

	@Autowired
	StudentResourceRepository studentResourceRepository;

	@Override
	public StudentResource saveStudentResource(StudentResource studentResource)
			throws Exception {
		return studentResource;
	}

	@Override
	public StudentResource findStudentResourceById(Long id) {
		StudentResource studentResource = studentResourceRepository
				.findOne(null);
		return studentResource;
	}

	@Override
	public List<StudentResource> findAllStudentResource() {
		List<StudentResource> studentResourceList = studentResourceRepository
				.findAll();
		return studentResourceList;
	}

	@Override
	public void deleteStudentResourceById(Long id) {
		studentResourceRepository.delete(null);
	}
}