package com.nrecinos.backend.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
@Size(max = 25, message = "Name is bigger than allowed")
String name;

@Size(max = 25, message = "Lastname is bigger than allowed")
String lastname;

@Size(min = 8, max = 11, message = "Phon number must be between 8 and 11 digits")
String phoneNumber;

@Email()
String email;

@Size(min = 8, max = 25, message = "Password must be between 8 and 25 digits")
String password;

String username;
}