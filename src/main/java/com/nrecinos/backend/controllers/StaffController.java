package com.nrecinos.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@PostMapping("/")
	ResponseEntity<?> create(@RequestBody @Valid CreateStaffDto craeteStaffDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	ResponseEntity<?> getAll(){
		//List<Staff> staff = staffService.getAll();
		//if(staff == null) {
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
		return new ResponseEntity<>("All Staff", HttpStatus.OK);
	} 
	
	@GetMapping("/{code}")
	ResponseEntity<?> getStaffById(@PathVariable(name = "code") Integer code){
		StaffInfoDto tier = null; //TODO: Update with service method
		if(tier == null) {
			return new ResponseEntity<>("Staff not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{code}")
	ResponseEntity<?> updateStaff(@PathVariable(name = "code") Integer code, @RequestBody @Valid UpdateStaffDto updateStaffDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{code}")
	ResponseEntity<?> delete(@PathVariable(name = "code") Integer code){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
