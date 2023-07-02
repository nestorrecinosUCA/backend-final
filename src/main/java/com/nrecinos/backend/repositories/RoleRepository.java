package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.role.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findOneByTitle(String title);
}
