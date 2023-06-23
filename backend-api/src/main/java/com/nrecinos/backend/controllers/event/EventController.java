package com.nrecinos.backend.controllers.event;

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

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.event.UpdateEventDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.CategoryRepository;
import com.nrecinos.backend.repositories.EventRepository;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.EventService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/events")
public class EventController {
	@Autowired
	EventService eventService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	@GetMapping("")
	ResponseEntity<?> getAll() {
		List<EventInfoDto> events = eventService.findAll();
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getOne(@PathVariable(name = "id")Integer id){
		EventInfoDto event = eventService.findOne(id); // TODO: update with service
		if(event == null) {
			return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	
	@PostMapping("")
	ResponseEntity<?> create(@RequestBody @Valid CreateEventDto createEventDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		System.out.println(createEventDto);
		User user = userRepository.findOneById(createEventDto.getUserId());
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		Category category = categoryRepository.findOneById(createEventDto.getCategoryId());
		if (category == null) {
			return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
		}
		eventService.create(createEventDto, user, category);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	ResponseEntity<?> update(@PathVariable(name = "id")Integer id, @RequestBody @Valid UpdateEventDto updateEventDto, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Event event = eventRepository.findOneById(id);
		if (event == null) {
			return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
		}
		if (updateEventDto.getCategoryId() != null) {
        	Category category = categoryRepository.findOneById(updateEventDto.getCategoryId());
        	if (category == null) {
        		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        	}
        }
		EventInfoDto eventUpdated = eventService.update(id, updateEventDto);
		return new ResponseEntity<>(eventUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
