package com.nrecinos.backend.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {
	@NotEmpty(message = "Name must not be empty")
	String name;

	@NotEmpty(message = "Lastname must not be empty")
	String lastname;

	@NotEmpty(message = "Phone number must not be empty")
	String phoneNumber;

	@NotEmpty(message = "Email must not be empty")
	@Email()
	String email;

	@NotEmpty(message = "Password must not be empty")
	String password;

	@NotEmpty(message = "Username must not be empty")
	String username;
}
