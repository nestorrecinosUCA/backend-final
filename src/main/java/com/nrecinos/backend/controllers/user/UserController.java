package com.nrecinos.backend.controllers.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrecinos.backend.models.dto.user.CreateUserDto;
import com.nrecinos.backend.models.dto.user.UpdateUserDto;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
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
	ResponseEntity<?> create(@RequestBody @Valid CreateUserDto createUserDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody @Valid UpdateUserDto updateteUserDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Updated Successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	String delete(@PathVariable(name = "id") Integer id) {
		return "Delete user with Id: " + id;
	}
}
