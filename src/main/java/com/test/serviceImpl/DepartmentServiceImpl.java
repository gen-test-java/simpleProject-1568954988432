package com.test.serviceImpl;

import org.springframework.stereotype.Service;
import com.test.repository.DepartmentRepository;
import com.test.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.services.DepartmentService;
import java.lang.Long;
import java.util.List;
import com.test.repository.StudentRepository;
import com.test.entity.Student;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Department saveDepartment(Department department) throws Exception {
		Department departmentDB = departmentRepository.save(department);
		if (department.getStudentList() != null) {
			List<Student> studentList = department.getStudentList();
			for (Student student : studentList) {
				student.setDepartment(departmentDB);
				studentRepository.save(student);
			}
		}
		return department;
	}

	@Override
	public Department findDepartmentById(Long id) {
		Department department = departmentRepository.findOne(id);
		return department;
	}

	@Override
	public List<Department> findAllDepartment() {
		List<Department> departmentList = departmentRepository.findAll();
		return departmentList;
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.delete(id);
	}
}