package com.nrecinos.backend.models.dtos.event;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

	@NotNull(message = "date must not be null")
	Date date;

	@NotEmpty(message = "hour must not be empty")
	String hour;

	@NotNull(message ="duration must not be empty")
	Float duration;
	// The isActive field is not created because it is true by default

	@NotNull(message = "assistantCapacity must not be null")
	Integer assistantsCapacity;

	@NotNull(message = "userId must not be empty")
	@Positive()
	Integer userId;

	@NotNull(message = "categoryId must not be null")
	@Positive()
	Integer categoryId;

}
