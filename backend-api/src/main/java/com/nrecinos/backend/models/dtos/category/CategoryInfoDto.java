package com.nrecinos.backend.models.dtos.category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryInfoDto {
	
	 String name;
	 String description;
	 
	 Integer idEvents;
}
