package com.nrecinos.backend.controllers.ticket;

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

import com.nrecinos.backend.models.dtos.ticket.CreateTicketDto;
import com.nrecinos.backend.models.dtos.ticket.TicketInfoDto;
import com.nrecinos.backend.models.dtos.ticket.UpdateTicketDto;
import com.nrecinos.backend.models.entities.ticket.Ticket;
import com.nrecinos.backend.models.entities.voucher.Voucher;
import com.nrecinos.backend.services.TicketService;
import com.nrecinos.backend.services.VoucherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	TicketService ticketService;
	@Autowired
	VoucherService voucherService;

	@PostMapping("")
	ResponseEntity<?> create(@RequestBody @Valid CreateTicketDto createTicketDto, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(validations.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Voucher voucher = voucherService.findOne(createTicketDto.getVoucherId());
		if (voucher == null) {
			return new ResponseEntity<>("Voucher not found", HttpStatus.CREATED);
		}
		TicketInfoDto newTicket = ticketService.create(createTicketDto);
		return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
	}
	
	@GetMapping("/voucher/{id}")
	ResponseEntity<?> getAll(@PathVariable(name = "id") Integer id){
		List<Ticket> tickets = ticketService.findAll(id);
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	} 
	
	@GetMapping("/{code}")
	ResponseEntity<?> getTicketById(@PathVariable(name = "code") Integer code){
		TicketInfoDto ticket = null; //TODO: Update with service method
		if(ticket == null) {
			return new ResponseEntity<>("Ticket not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{code}")
	ResponseEntity<?> updateTicket(@PathVariable(name = "code") Integer code, @RequestBody @Valid UpdateTicketDto updateTicketDto, BindingResult validations){
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
