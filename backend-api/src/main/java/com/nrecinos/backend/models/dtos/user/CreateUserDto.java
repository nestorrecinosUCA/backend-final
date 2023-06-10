package com.nrecinos.backend.models.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {
	@Size(max = 25, message = "Name is bigger than allowed")
	@NotEmpty(message = "Name must not be empty")
	String name;

	@Size(max = 25, message = "Lastname is bigger than allowed")
	@NotEmpty(message = "Lastname must not be empty")
	String lastname;

	@Size(min = 8, max = 11, message = "Phon number must be between 8 and 11 digits")
	@NotEmpty(message = "Phone number must not be empty")
	String phoneNumber;

	@NotEmpty(message = "Email must not be empty")
	@Email()
	String email;

	@Size(min = 8, max = 25, message = "Password must be between 8 and 25 digits")
	@NotEmpty(message = "Password must not be empty")
	String password;

	@NotEmpty(message = "Username must not be empty")
	String username;
}
