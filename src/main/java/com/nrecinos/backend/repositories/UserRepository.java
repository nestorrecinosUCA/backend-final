package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneById(Integer id);
	User findByUsernameOrEmail(String username, String email);
	User findByUsernameOrEmailAndIsVerified(String username, String email, Boolean isVerified);
}
