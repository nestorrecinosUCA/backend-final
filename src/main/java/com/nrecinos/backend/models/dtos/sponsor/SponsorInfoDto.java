package com.nrecinos.backend.models.dtos.sponsor;

import com.nrecinos.backend.models.entities.event.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SponsorInfoDto {
	String name;
	Event event;
}
