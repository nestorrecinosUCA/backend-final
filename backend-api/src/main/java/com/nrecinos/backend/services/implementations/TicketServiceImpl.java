package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.ticket.CreateTicketDto;
import com.nrecinos.backend.models.dtos.ticket.TicketInfoDto;
import com.nrecinos.backend.models.dtos.ticket.UpdateTicketDto;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.models.entities.ticket.Ticket;
import com.nrecinos.backend.models.entities.voucher.Voucher;
import com.nrecinos.backend.repositories.TicketRepository;
import com.nrecinos.backend.repositories.VoucherRepository;
import com.nrecinos.backend.services.TicketService;
import com.nrecinos.backend.services.VoucherService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private VoucherService voucherService;
	@Autowired
	VoucherRepository voucherRepository;
	
	@Override
	public TicketInfoDto create(CreateTicketDto info) {
		Voucher voucher = voucherRepository.findOneById(info.getVoucherId());
		Ticket newTicket = new Ticket(
				info.getTitle(),
				info.getDescription(),
				voucher
				);
		
		Ticket saveTicket = this.save(newTicket);
		TicketInfoDto ticketInfo = this.serializeTicketInfoDto(saveTicket);
		
		return ticketInfo;
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<TicketInfoDto> findAll(Integer id) {
		List<Ticket> tickets = ticketRepository.findAllByVoucherId(id);
		List<TicketInfoDto> serializedTickets = tickets
				.stream()
				.map(ticket -> this.serializeTicketInfoDto(ticket))
				.toList();
		return serializedTickets;
	}

	@Override
	public TicketInfoDto findOne(Integer code) {
		Ticket ticket = ticketRepository.findOneById(code);
		if(ticket == null) {
			return null;
		}
		TicketInfoDto ticketInfo= this.serializeTicketInfoDto(ticket);
		return ticketInfo;
	}

	@Override
	public TicketInfoDto update(Integer code, UpdateTicketDto updateCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer code) {
		ticketRepository.deleteById(code);
	}
	
	@Override
	public TicketInfoDto serializeTicketInfoDto(Ticket ticket) {
		return new TicketInfoDto(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getVoucher().getId());
	}

}
