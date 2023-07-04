package com.nrecinos.backend.models.dtos.event;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateEventDto {
	@Size(max = 50, message = "Title is bigger than allowed")
	String title;

	@Size(max = 200, message = "Description is bigger than allowed")
	String description;

	Date date;
	
	// Add a regex to validate the hour
	String hour;
	
	@Positive()
	Float duration;
	// The isActive field is not created because it is true by default
 
	@Positive()
	Integer assistantsCapacity;
	
	@Positive()
	Integer categoryId;
  
	String image;
}
