package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.ticket.CreateTicketDto;
import com.nrecinos.backend.models.dtos.ticket.TicketInfoDto;
import com.nrecinos.backend.models.dtos.ticket.UpdateTicketDto;
import com.nrecinos.backend.models.entities.ticket.Ticket;

public interface TicketService {
	TicketInfoDto create(CreateTicketDto createTicketDto);
	Ticket save(Ticket ticket);
	List<Ticket> findAll(Integer id);
	TicketInfoDto findOne(Integer id);
	TicketInfoDto update(Integer id, UpdateTicketDto updateTicketDto);
	void delete(Integer id);
	TicketInfoDto serializeTicketInfoDto(Ticket ticket);
}
