package com.nrecinos.backend.models.entities.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
	Integer id;
	String name;
	String description;
}
