package com.nrecinos.backend.models.entities.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	String name;
	String lastname;
	String phoneNumber;
	String email;
	String password;
	String username;
	Boolean isVerified;
	// TODO Add valid relationship when these modules are added
	Integer rolId;
	Integer eventId;
	Integer ticketId;
}
