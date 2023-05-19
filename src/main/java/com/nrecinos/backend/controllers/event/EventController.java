package com.nrecinos.backend.controllers.event;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	String create() {
		return "Event created";
	}

	@PatchMapping("/{id}")
	String update() {
		return "Update event";
	}
	
	@DeleteMapping("/{id}")
	String delete() {
		return "Delete item";
	}
}
