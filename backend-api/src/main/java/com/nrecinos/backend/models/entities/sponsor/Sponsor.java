package com.nrecinos.backend.models.entities.sponsor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sponsor {
	Integer id;
	String name;
	Integer eventId;
	
}
