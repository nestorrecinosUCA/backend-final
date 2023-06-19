package com.nrecinos.backend.models.entities.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.users_roles_role.UsersXRoles;
import com.nrecinos.backend.models.entities.voucher.Voucher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	@Column(name = "is_verified")
	private Boolean isVerified;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UsersXRoles> usersXRole;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Event> events;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Voucher> vouchers;

	public User(String name, String lastname, String phoneNumber, String email, String password, String username,
			Boolean isVerified) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.username = username;
		this.isVerified = isVerified;
	}
}
