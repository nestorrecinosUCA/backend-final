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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {
	@GetMapping("/")
	String getAll() {
		return "All events";
	}
	
	@GetMapping("/{id}")
	String getOneById() {
		return "a single event";
	}
	
	@PostMapping("/")
	ResponseEntity<?> create(@RequestBody @Valid CreateEventDto createEventDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	String update() {
		return "Update event";
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
