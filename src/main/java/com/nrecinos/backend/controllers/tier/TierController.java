package com.nrecinos.backend.controllers.tier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.tier.CreateTierDto;
import com.nrecinos.backend.models.dtos.tier.TierInfoDto;
import com.nrecinos.backend.models.dtos.tier.UpdateTierDto;
import com.nrecinos.backend.services.EventService;
import com.nrecinos.backend.services.TierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tiers")
public class TierController {
	@Autowired
	TierService tierService;
	@Autowired
	EventService eventService;
	
	@PostMapping("")
	ResponseEntity<?> create(@RequestBody @Valid CreateTierDto createTierDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		EventInfoDto event = eventService.findOne(createTierDto.getEventId());
		if (event == null) {
			return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
		}
		TierInfoDto savedTier = tierService.create(createTierDto);
		return new ResponseEntity<>(savedTier, HttpStatus.CREATED);
	}
	
	@GetMapping("/event/{id}")
	ResponseEntity<?> getAll(@PathVariable(name = "id") Integer id){
		EventInfoDto event = eventService.findOne(id);
		if (event == null) {
			return new ResponseEntity<>("Event not Found", HttpStatus.NOT_FOUND);
		}
		List<TierInfoDto> tiers = tierService.findAll(id);
		return new ResponseEntity<>(tiers, HttpStatus.OK);
	} 
	
	@GetMapping("/{id}")
	ResponseEntity<?> getTierById(@PathVariable(name = "id") Integer id){
		TierInfoDto tier = tierService.findOne(id); //TODO: Update with service method
		if(tier == null) {
			return new ResponseEntity<>("Tier not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tier, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	ResponseEntity<?> updateTier(@PathVariable(name = "id") Integer id, @RequestBody @Valid UpdateTierDto updateTierDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		TierInfoDto tier = tierService.findOne(id);
		if (tier == null) {
			return new ResponseEntity<>("Tier not found", HttpStatus.NOT_FOUND);
		}
		TierInfoDto updatedTier = tierService.update(id, updateTierDto);
		return new ResponseEntity<>(updatedTier, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
		TierInfoDto tier = tierService.findOne(id);
		if (tier == null) {
			return new ResponseEntity<>("Tier not found", HttpStatus.NOT_FOUND);
		}
		tierService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
