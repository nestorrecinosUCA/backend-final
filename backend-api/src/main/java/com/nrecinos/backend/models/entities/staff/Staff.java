package com.nrecinos.backend.models.entities.staff;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Staff {
	Integer id;
	String name;
	String type;
	Integer eventId;
}
