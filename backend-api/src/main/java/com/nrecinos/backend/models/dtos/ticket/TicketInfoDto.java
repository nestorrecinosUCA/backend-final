package com.nrecinos.backend.models.dtos.ticket;

import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.voucher.Voucher;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TicketInfoDto {
	String title;
	String description;
	Voucher voucher;
}
