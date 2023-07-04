package com.nrecinos.backend.services;

import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.entities.user.User;

public interface AuthService {
	void singUp(CreateUserDto user);
	User signIn(String identificator, String password);
	Boolean comparePassword(String toCompare, String current);

}
