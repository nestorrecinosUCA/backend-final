package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;
import com.nrecinos.backend.models.dtos.user.UserInfoDto;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Override
	public UserInfoDto create(CreateUserDto createUserDto) {
		User createUser = new User(createUserDto.getName(), createUserDto.getLastname(), createUserDto.getPhoneNumber(), createUserDto.getEmail(), passwordEncoder.encode(createUserDto.getPassword()), createUserDto.getUsername(), false);
		User saveUser = this.save(createUser);
		UserInfoDto userInfo = this.serializeUserInfoDto(saveUser);
		return userInfo;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<UserInfoDto> findAll() {
		List<User> users = userRepository.findAll();
		List<UserInfoDto> usersInfoDto = users.stream()
				.map(u -> this.serializeUserInfoDto(u)).toList();
		return usersInfoDto;
	}

	@Override
	public UserInfoDto findOne(Integer code) {
		User user = userRepository.findOneById(code);
		if (user == null) {
			return null;
		}
		UserInfoDto userInfo = this.serializeUserInfoDto(user);
		return userInfo;
	}

	@Override
	public UserInfoDto update(Integer code, UpdateUserDto updateCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoDto updateStatus(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInfoDto serializeUserInfoDto(User user) {
		return new UserInfoDto(user.getName(), user.getLastname(), user.getPhoneNumber(), user.getEmail(), user.getUsername(), user.getIsVerified());
	}

	@Override
	public UserInfoDto findByEmailOrUsername(String email, String username) {
		User user = userRepository.findByUsernameOrEmail(username, email);
		if (user != null) {			
			return this.serializeUserInfoDto(user);
		}
		return null;
	}

}
