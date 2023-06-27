package com.nrecinos.backend.models.dtos.tier;

import com.nrecinos.backend.models.entities.event.Event;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTierDto {
	@NotEmpty(message = "name must not be empty")
	String name;
	
	@NotEmpty(message = "description must not be empty")
	String description;
	
	@NotNull(message = "capacity must be a number")
	@Min(value = 1, message = "capacity must be a number greater than 0")
	Integer capacity;
	
	@NotNull(message = "price must be a number")
	@Min(value = 1, message = "price must be a number greater than 0")
	Float price;
	
	@NotNull(message = "eventId must be a number")
	@Min(value = 1, message = "eventId must be a number greater than 0")
	Integer eventId;
}
