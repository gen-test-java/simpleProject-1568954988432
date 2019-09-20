package com.test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.test.entity.Student;
import com.test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<?> getAllStudent() throws Exception {
		try {
			List<Student> students = studentService.findAllStudent();
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Student is Null.");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteStudent(@PathVariable Long id)
			throws Exception {
		try {
			studentService.deleteStudentById(id);
			return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Student is Deleted.");
		}
	}

	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.toString(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			student = studentService.saveStudent(student);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Student could not be Saved.");
		}
	}
}