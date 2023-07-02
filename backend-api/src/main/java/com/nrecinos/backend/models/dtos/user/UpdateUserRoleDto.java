package com.nrecinos.backend.models.dtos.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRoleDto {
	Integer userId;
	String role;
}
