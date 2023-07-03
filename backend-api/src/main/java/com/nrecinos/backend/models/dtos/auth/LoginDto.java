package com.nrecinos.backend.models.dtos.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDto {
	@NotEmpty(message = "username cannot be empty")
	String username;

	@NotEmpty(message = "password cannot be empty")
	String password;
}
