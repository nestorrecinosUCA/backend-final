package com.nrecinos.backend.models.dtos.event;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEventDto {
	@Size(max = 50, message = "Title is bigger than allowed")
	@NotEmpty(message = "title must not be empty")
	String title;

	@Size(max = 200, message = "Description is bigger than allowed")
	@NotEmpty(message = "description must not be empty")
	String description;

	@NotEmpty(message = "date must not be empty")
	Date date;

	@NotEmpty(message = "hour must not be empty")
	String hour;

	@NotEmpty(message ="duration must not be empty")
	Float duration;
	// The isActive field is not created because it is true by default

	@NotEmpty(message = "assistantCapacity must not be empty") 
	Integer assistantsCapacity;

	@NotEmpty(message = "userId must not be empty")
	Integer userId;

	@NotEmpty(message = "tierId must not be empty")
	Integer tierId;

	@NotEmpty(message = "categoryId must not be empty")
	Integer categoryId;
}
