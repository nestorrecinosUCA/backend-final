package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.ticket.CreateTicketDto;
import com.nrecinos.backend.models.dtos.ticket.TicketInfoDto;
import com.nrecinos.backend.models.dtos.ticket.UpdateTicketDto;
import com.nrecinos.backend.models.entities.ticket.Ticket;

public interface TicketService {
	TicketInfoDto create(CreateTicketDto createTicketDto);
	Ticket save(Ticket ticket);
	List<Ticket> findAll();
	TicketInfoDto findOne(Integer code);
	TicketInfoDto update(Integer code, UpdateTicketDto updateTicketDto);
	void delete(Integer code);
	TicketInfoDto serializeTicketInfoDto(Ticket ticket);
}
