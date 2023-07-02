package com.nrecinos.backend.models.dtos.user;

import java.util.List;

import com.nrecinos.backend.models.entities.users_roles_role.UsersXRoles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
	Integer id;
	String name;
	String lastname;
	String phoneNumber;
	String email;
	String username;
	Boolean isVerified;
	List<String> roles;
	// TODO Add valid relationship when these modules are added
	//Integer rolId;
	//Integer eventId;
	//Integer ticketId;
}
