package com.nrecinos.backend.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nrecinos.backend.models.dtos.auth.LoginDto;
import com.nrecinos.backend.models.dtos.general.MessageDto;
import com.nrecinos.backend.models.dtos.token.TokenDto;
import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.entities.token.Token;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.AuthService;
import com.nrecinos.backend.services.UserService;
import com.nrecinos.backend.utils.RequestErrorsHandler;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	RequestErrorsHandler errorHandler;
	@PostMapping("/signup")
	public ResponseEntity<?> singUp(@RequestBody @Valid CreateUserDto createUser, BindingResult validations){
		
		if(validations.hasErrors()){
			return new ResponseEntity<>(
					   errorHandler.mapErrors(validations.getFieldErrors()),
					   HttpStatus.BAD_REQUEST);
		}
		
		String username = createUser.getUsername();
		String email = createUser.getEmail();
		
		if (userRepository.findByUsernameOrEmail(username, email) != null) {
			return new ResponseEntity<>(
					new MessageDto("Username or email already exist"),
					HttpStatus.BAD_REQUEST);
		}
		
		try {
			userService.create(createUser);
			return new ResponseEntity<>(
					new MessageDto("User created"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(
					new MessageDto("Internal server error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginDto info, BindingResult validations){
		User user = authService.signIn(info.getUsername(), info.getPassword());
		if (user == null) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		try {
			Token token = userService.registerToken(user);
			return new ResponseEntity<>(new TokenDto(token), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
