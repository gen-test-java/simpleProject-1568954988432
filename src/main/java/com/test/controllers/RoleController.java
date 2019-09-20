package com.test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.test.entity.Role;
import com.test.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<?> getAllRole() throws Exception {
		try {
			List<Role> roles = roleService.findAllRole();
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Role is Null.");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteRole(@PathVariable Long id) throws Exception {
		try {
			roleService.deleteRoleById(id);
			return new ResponseEntity<>("Deleted Successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Role is Deleted.");
		}
	}

	@PostMapping
	public ResponseEntity<?> saveRole(@RequestBody Role role,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.toString(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			role = roleService.saveRole(role);
			return new ResponseEntity<>(role, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Role could not be Saved.");
		}
	}
}