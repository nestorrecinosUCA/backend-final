package com.nrecinos.backend.models.dtos.ticket;

import com.nrecinos.backend.models.dtos.sponsor.CreateSponsorDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.voucher.Voucher;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreateTicketDto {
	String title;
	String description;
	Voucher voucher;
}
