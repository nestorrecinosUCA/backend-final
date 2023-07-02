package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.users_roles_role.UsersXRoles;

public interface UsersXRolesRepository extends JpaRepository<UsersXRoles, Integer>{
	UsersXRoles findOneById(Integer id);
	UsersXRoles findOneByUserIdAndRoleId(Integer userId, Integer roleId);
}
