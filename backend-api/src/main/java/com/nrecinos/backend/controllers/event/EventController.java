package com.nrecinos.backend.controllers.event;

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

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {
	@GetMapping("/")
	ResponseEntity<?> getAll() {
		// TODO: update with service method and create variable
		return new ResponseEntity<>("All users", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getOne(@PathVariable(name = "id")Integer id){
		EventInfoDto event = null; // TODO: update with service
		if(event == null) {
			return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Single event with id: " + id, HttpStatus.OK);
	}
	
	@PostMapping("/")
	ResponseEntity<?> create(@RequestBody @Valid CreateEventDto createEventDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	ResponseEntity<?> update(@RequestBody @Valid UpdateUserDto updateUserDto, BindingResult validations) {
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
