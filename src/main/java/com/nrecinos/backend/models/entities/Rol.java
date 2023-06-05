package com.nrecinos.backend.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rol {
	Integer id;
	String name;
	String description;
	Integer userId;
}
