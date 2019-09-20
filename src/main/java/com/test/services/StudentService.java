package com.test.services;

import com.test.entity.Student;
import java.lang.Long;
import java.util.List;

public interface StudentService {

	Student saveStudent(Student student) throws Exception;

	Student findStudentById(Long id);

	List<Student> findAllStudent();

	void deleteStudentById(Long id);
}