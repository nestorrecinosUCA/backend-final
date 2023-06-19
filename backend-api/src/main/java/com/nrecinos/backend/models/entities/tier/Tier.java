package com.nrecinos.backend.models.entities.tier;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.tickets_tiers_tier.TicketsXTiers;

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
@Table(name = "tier")
public class Tier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "sold")
	private Integer sold;
	
	@Column(name = "is_sold_out")
	private Boolean isSoldOut;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eventId")
	@ToString.Exclude
	private Event event;
	
	@OneToMany(mappedBy = "tier", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TicketsXTiers> ticketsXTiers;

	public Tier(String name, String description, Integer capacity, Float price, Integer sold, Boolean isSoldOut,
			Event event) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.price = price;
		this.sold = sold;
		this.isSoldOut = isSoldOut;
		this.event = event;
	}
}
