package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.ticket.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	Ticket findOneById(Integer id);

}
