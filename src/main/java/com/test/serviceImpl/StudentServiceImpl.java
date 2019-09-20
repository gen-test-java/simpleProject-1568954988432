package com.test.serviceImpl;

import org.springframework.stereotype.Service;
import com.test.repository.StudentRepository;
import com.test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.services.StudentService;
import java.lang.Long;
import java.util.List;
import com.test.repository.DepartmentRepository;
import com.test.entity.Department;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Student saveStudent(Student student) throws Exception {
		Department department = departmentRepository.findOne(student
				.getDepartment().getId());
		if (department != null) {
			student.setDepartment(department);
			student = studentRepository.save(student);
		} else {
			throw new Exception("Department does not exist.");
		}
		Department department = departmentRepository.findOne(student
				.getDepartment().getId());
		if (department != null) {
			student.setDepartment(department);
			student = studentRepository.save(student);
		} else {
			throw new Exception("Department does not exist.");
		}
		return student;
	}

	@Override
	public Student findStudentById(Long id) {
		Student student = studentRepository.findOne(id);
		return student;
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.delete(id);
	}
}