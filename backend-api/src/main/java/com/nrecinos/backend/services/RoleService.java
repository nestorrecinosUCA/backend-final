package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.entities.role.Role;

public interface RoleService {
	List<Role> getAll();
	Role getOneByName(String name);
}
