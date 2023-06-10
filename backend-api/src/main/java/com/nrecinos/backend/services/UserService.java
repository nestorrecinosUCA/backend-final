package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.user.CreateUserDto;
import com.nrecinos.backend.models.dtos.user.UpdateUserDto;
import com.nrecinos.backend.models.dtos.user.UserInfoDto;
import com.nrecinos.backend.models.entities.user.User;

public interface UserService {
	UserInfoDto create(CreateUserDto createCategoryDto);
	User save(User category);
	List<User> findAll();
	UserInfoDto findOne(Integer code);
	UserInfoDto update(Integer code, UpdateUserDto updateCategoryDto);
	void delete(Integer code);
}
