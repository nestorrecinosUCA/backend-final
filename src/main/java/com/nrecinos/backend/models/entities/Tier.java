package com.nrecinos.backend.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tier {
	Integer id;
	String name;
	String description;
	Integer capacity;
	Float price;
	Integer sold;
	Boolean isSoldOut;
	Integer eventId;
}
