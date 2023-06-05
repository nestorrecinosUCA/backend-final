package com.nrecinos.backend.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
	Integer id;
	String title;
	String description;
	Integer userId;
	Integer tierId;
}
