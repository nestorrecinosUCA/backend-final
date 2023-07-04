package com.nrecinos.backend.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nrecinos.backend.models.dtos.user.UserInfoDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class RoleValidator {
	@Autowired
	JWTTools jwtTools;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	
	public Boolean validateRoles(List<String> rolesToValidate, HttpServletRequest request) {
		String token = jwtTools.extractTokenFromRequest(request);
		String username = jwtTools.getUsernameFrom(token);
		User user = userRepository.findByUsernameOrEmail(username, username);
		UserInfoDto serializedUser = userService.serializeUserInfoDto(user);
		Boolean result = false;
		for (String role : rolesToValidate) {
			for(String userRole: serializedUser.getRoles()) {
				if (role.equals(userRole)) {
					result = true;
					break;
				}
			}
			if(!result) {
				return false;
			}
		}
		return result;
	}
}
