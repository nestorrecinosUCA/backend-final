package com.nrecinos.backend.models.dtos.token;

import com.nrecinos.backend.models.entities.token.Token;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDto {
	private String token;
	
	public TokenDto(Token token) {
		this.token = token.getContent();
	}
}
