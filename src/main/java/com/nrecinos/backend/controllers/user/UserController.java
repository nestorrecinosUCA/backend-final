package com.nrecinos.backend.controllers.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping("/")
	String getAllUsers() {
		return "All users";
	}
	
	@GetMapping("/{id}")
	String getOne(@PathVariable(name = "id") Integer id){
		return "Single user with id: " + id;
	}
	
	@PostMapping("/")
	String create() {
		return "User created";
	}
	
	@PatchMapping("/{id}")
	String update(@PathVariable(name = "id") Integer id) {
		return "Update user with id " + id;
	}
	
	@DeleteMapping("/{id}")
	String delete(@PathVariable(name = "id") Integer id) {
		return "Delete user with Id: " + id;
	}
}
