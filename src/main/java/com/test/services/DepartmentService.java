package com.test.services;

import com.test.entity.Department;
import java.lang.Long;
import java.util.List;

public interface DepartmentService {

	Department saveDepartment(Department department) throws Exception;

	Department findDepartmentById(Long id);

	List<Department> findAllDepartment();

	void deleteDepartmentById(Long id);
}