package com.nrecinos.backend.models.dtos.tier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TierInfoDto {
	Integer id;
	String name;
	String description;
	Integer capacity;
	Float price;
	Integer sold;
	Boolean isSoldOut;
	String eventName;
	Integer eventId;
}
