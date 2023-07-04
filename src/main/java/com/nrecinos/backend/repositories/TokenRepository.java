package com.nrecinos.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.token.Token;
import com.nrecinos.backend.models.entities.user.User;

public interface TokenRepository extends JpaRepository<Token, Integer>{
	List<Token> findByUserAndActive(User user, Boolean active);
}
