package com.nrecinos.backend.models.dtos.category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCategoryDto {
	 String name;
	 String description;
}
