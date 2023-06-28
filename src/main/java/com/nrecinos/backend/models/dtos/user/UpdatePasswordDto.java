package com.nrecinos.backend.models.dtos.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatePasswordDto {
	@Size(min = 8, max = 25, message = "Password must be between 8 and 25 digits")
	@NotEmpty(message = "Password must not be empty")
	String password;
}
