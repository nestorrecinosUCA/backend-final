package com.nrecinos.backend.models.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
	String title;
	String description;
	Date date;
	String hour;
	Float duration;
	Boolean isActive;
	Integer assistants;
	Integer assistantsCapacity;
	// TODO Update relationships
	Integer userId;
	Integer tierId;
	Integer categoryId;
}
