package com.test.services;

import com.test.entity.StudentResource;
import java.lang.Long;
import java.util.List;

public interface StudentResourceService {

	StudentResource saveStudentResource(StudentResource studentResource)
			throws Exception;

	StudentResource findStudentResourceById(Long id);

	List<StudentResource> findAllStudentResource();

	void deleteStudentResourceById(Long id);
}