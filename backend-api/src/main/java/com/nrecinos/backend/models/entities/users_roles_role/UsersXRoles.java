package com.nrecinos.backend.models.entities.users_roles_role;

import com.nrecinos.backend.models.entities.role.Role;
import com.nrecinos.backend.models.entities.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "user_roles_role")
public class UsersXRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@ToString.Exclude
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	@ToString.Exclude
	private Role role;
	
	public UsersXRoles(Role role, User user) {
		this.role = role;
		this.user = user;
	}
}
