package com.test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.test.entity.Department;
import com.test.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<?> getAllDepartment() throws Exception {
		try {
			List<Department> departments = departmentService
					.findAllDepartment();
			return new ResponseEntity<>(departments, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Department is Null.");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id)
			throws Exception {
		try {
			departmentService.deleteDepartmentById(id);
			return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Department is Deleted.");
		}
	}

	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.toString(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			department = departmentService.saveDepartment(department);
			return new ResponseEntity<>(department, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Department could not be Saved.");
		}
	}
}