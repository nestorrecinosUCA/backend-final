package com.nrecinos.backend.models.dtos.sponsor;

import com.nrecinos.backend.models.entities.event.Event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSponsorDto {
	String name;
	Event event;
}
