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
	
	@PostMapping("/")
	ResponseEntity<?> create(@RequestBody @Valid CreateTierDto craeteTierDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/event/{id}")
	ResponseEntity<?> getAll(@PathVariable(name = "id") Integer id){
		EventInfoDto event = eventService.findOne(id);
		if (event == null) {
			return new ResponseEntity<>("Event not Found", HttpStatus.NOT_FOUND);
		}
		List<TierInfoDto> tiers = tierService.findAll();
		return new ResponseEntity<>(tiers, HttpStatus.OK);
	} 
	
	@GetMapping("/{code}")
	ResponseEntity<?> getTierById(@PathVariable(name = "code") Integer code){
		TierInfoDto tier = null; //TODO: Update with service method
		if(tier == null) {
			return new ResponseEntity<>("Tier not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{code}")
	ResponseEntity<?> updateTier(@PathVariable(name = "code") Integer code, @RequestBody @Valid UpdateTierDto updateTierDto, BindingResult validations){
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
