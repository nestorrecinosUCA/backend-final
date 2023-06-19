package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public UserInfoDto create(CreateUserDto createCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public UserInfoDto findOne(Integer code) {
		User user = userRepository.findOneById(code);
		if (user == null) {
			return null;
		}
		UserInfoDto userInfo = new UserInfoDto(user.getName(), user.getLastname(), user.getPhoneNumber(), user.getEmail(), user.getUsername(), user.getIsVerified());
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

}
