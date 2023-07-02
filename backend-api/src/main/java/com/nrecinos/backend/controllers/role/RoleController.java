package com.nrecinos.backend.controllers.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.backend.models.entities.role.Role;
import com.nrecinos.backend.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping("")
	ResponseEntity<?> getAll() {
		List<Role> roles = roleService.getAll();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	ResponseEntity<?> getOneByName(@PathVariable(name = "name") String name){
		Role role = roleService.getOneByName(name);
		if (role == null) {
			return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
}
