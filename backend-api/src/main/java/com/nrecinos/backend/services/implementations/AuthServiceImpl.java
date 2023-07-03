package com.nrecinos.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.AuthService;
import com.nrecinos.backend.services.UserService;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void singUp(CreateUserDto user) {
		userService.create(user);
	}

	@Override
	public User signIn(String identificator, String password) {
		System.out.println(identificator);
		User user = userRepository.findByUsernameOrEmail(identificator, identificator);
		if (user != null) {			
			Boolean passwordMatches = this.comparePassword(password, user.getPassword());
			if (passwordMatches == true) {
				return user;			
			}
		}
		return null;
	}

	@Override
	public Boolean comparePassword(String toCompare, String current) {
		return passwordEncoder.matches(toCompare, current);
	}
}
