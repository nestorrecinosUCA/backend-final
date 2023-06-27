package com.nrecinos.backend.models.dtos.sponsor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSponsorDto {
	@NotEmpty(message = "Name must not be empty")
	String name;
	
	@NotNull(message= "eventId must not be null")
	Integer eventId;
}
