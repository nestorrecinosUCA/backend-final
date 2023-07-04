package com.nrecinos.backend.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.nrecinos.backend.models.dtos.user.UpdatePasswordDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserRoleDto;
import com.nrecinos.backend.models.dtos.user.UserInfoDto;
import com.nrecinos.backend.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("")
	ResponseEntity<?> getAllUsers() {
		List<UserInfoDto> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
		UserInfoDto user = userService.findOne(id); // TODO: Update with service method
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("")
	ResponseEntity<?> create(@RequestBody @Valid CreateUserDto createUserDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		UserInfoDto existingUser = userService.findByEmailOrUsername(createUserDto.getEmail(), createUserDto.getUsername());
		if (existingUser != null) {
			return new ResponseEntity<>("This email or username has already been registered", HttpStatus.BAD_REQUEST);
		}
		
		UserInfoDto newUser = userService.create(createUserDto);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody @Valid UpdateUserDto updateUserDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		UserInfoDto existingUser = userService.findOne(id);
		if (existingUser == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		if (existingUser.getEmail().equals(updateUserDto.getEmail()) || existingUser.getUsername().equals(updateUserDto.getUsername())) {
			return new ResponseEntity<>("This email or username has already been registered", HttpStatus.BAD_REQUEST);
		}
		UserInfoDto updatedUser = userService.update(id, updateUserDto);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}/verified")
	ResponseEntity<?> updateStatus(@PathVariable(name = "id") Integer id) {
		UserInfoDto userFound = userService.findOne(id);
		if (userFound == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		UserInfoDto updatedUser = userService.updateStatus(id);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}/password")
	ResponseEntity<?> updatePassword(@PathVariable(name = "id") Integer id, @RequestBody @Valid UpdatePasswordDto updatePasswordDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		UserInfoDto userFound = userService.findOne(id);
		if (userFound == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		String updatedMessage = userService.updatePassword(id, updatePasswordDto.getPassword());
		return new ResponseEntity<>(updatedMessage, HttpStatus.OK);
	}
	
	@PatchMapping("/add-role")
	ResponseEntity<?> addRole(@RequestBody @Valid UpdateUserRoleDto addRoleDto, BindingResult validations) {
		UserInfoDto existingUser = userService.findOne(addRoleDto.getUserId());
		if (existingUser == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		String updateMessage = userService.addRoleToUser(addRoleDto);
		if (updateMessage == null) {
			return new ResponseEntity<>("Role already assigned", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(updateMessage, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/remove-role")
	ResponseEntity<?> removeRole(@RequestBody @Valid UpdateUserRoleDto addRoleDto, BindingResult validations) {
		UserInfoDto existingUser = userService.findOne(addRoleDto.getUserId());
		if (existingUser == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		String updateMessage = userService.removeRoleFromUser(addRoleDto);
		if (updateMessage == null) {
			return new ResponseEntity<>("That role was not assigned to the user", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(updateMessage, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
		UserInfoDto existingUser = userService.findOne(id);
		if (existingUser == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
