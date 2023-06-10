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

import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;
import com.nrecinos.backend.models.dtos.user.UserInformationDto;
import com.nrecinos.backend.models.entities.user.UserEntity;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	@GetMapping("/")
	ResponseEntity<?> getAllUsers() {
		// TODO: update with service method and create variable
		return new ResponseEntity<>("All users", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
		UserInformationDto user = null; // TODO: Update with service method
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Single user with id: " + id, HttpStatus.OK);
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
		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
