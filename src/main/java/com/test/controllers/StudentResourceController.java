package com.test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.test.entity.StudentResource;
import com.test.services.StudentResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/studentresource")
public class StudentResourceController {

	@Autowired
	private StudentResourceService studentResourceService;

	@GetMapping
	public ResponseEntity<?> getAllStudentResource() throws Exception {
		try {
			List<StudentResource> studentResources = studentResourceService
					.findAllStudentResource();
			return new ResponseEntity<>(studentResources, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StudentResource is Null.");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteStudentResource(@PathVariable Long id)
			throws Exception {
		try {
			studentResourceService.deleteStudentResourceById(id);
			return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StudentResource is Deleted.");
		}
	}

	@PostMapping
	public ResponseEntity<?> saveStudentResource(
			@RequestBody StudentResource studentResource, BindingResult errors)
			throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.toString(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			studentResource = studentResourceService
					.saveStudentResource(studentResource);
			return new ResponseEntity<>(studentResource, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StudentResource could not be Saved.");
		}
	}
}