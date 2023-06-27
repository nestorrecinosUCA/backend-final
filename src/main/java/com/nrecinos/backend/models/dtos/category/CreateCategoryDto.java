package com.nrecinos.backend.models.dtos.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCategoryDto {
	@NotEmpty(message = "The name must not be empty")
	String name;
	
	@NotEmpty(message = "The description must not be empty")
	String description;
}
