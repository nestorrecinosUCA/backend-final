package com.nrecinos.backend.models.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
	String name;
	String lastname;
	String phoneNumber;
	String email;
	String username;
	Boolean isVerified;
	// TODO Add valid relationship when these modules are added
	Integer rolId;
	Integer eventId;
	Integer ticketId;
}
