package com.nrecinos.backend.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
@Size()
String name;

@Size()
String lastname;

@Size()
String phoneNumber;

@Size()
@Email()
String email;

@Size()
String password;

@Size()
String username;
}