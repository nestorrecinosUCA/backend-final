package com.nrecinos.backend.models.dtos.tier;

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
	Integer eventId;
}
