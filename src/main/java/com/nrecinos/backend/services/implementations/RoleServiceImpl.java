package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.entities.role.Role;
import com.nrecinos.backend.repositories.RoleRepository;
import com.nrecinos.backend.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getOneByName(String name) {
		Role role = roleRepository.findOneByTitle(name);
		return role;
	}

}
