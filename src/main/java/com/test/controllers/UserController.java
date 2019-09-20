package com.test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.test.entity.User;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getAllUser() throws Exception {
		try {
			List<User> users = userService.findAllUser();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User is Null.");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUser(@PathVariable Long id) throws Exception {
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User is Deleted.");
		}
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.toString(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			user = userService.saveUser(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User could not be Saved.");
		}
	}
}