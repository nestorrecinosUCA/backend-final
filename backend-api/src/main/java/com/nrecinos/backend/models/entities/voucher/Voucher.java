package com.nrecinos.backend.models.entities.voucher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrecinos.backend.models.entities.ticket.Ticket;
import com.nrecinos.backend.models.entities.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "voucher")
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "total")
	private Integer total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@ToString.Exclude
	private User user;
	
	@OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket> tickets;

	public Voucher(Integer quantity, Integer total, User user) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.user = user;
	}
}
