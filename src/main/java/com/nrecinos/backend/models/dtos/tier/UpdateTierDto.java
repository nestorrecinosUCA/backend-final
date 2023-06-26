package com.nrecinos.backend.models.dtos.tier;

import com.nrecinos.backend.models.entities.event.Event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateTierDto {
	String name;
	String description;
	Integer capacity;
	Float price;
	Integer sold;
	Boolean isSoldOut;
	Event event;
}
