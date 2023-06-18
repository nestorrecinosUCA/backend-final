package com.nrecinos.backend.models.entities.tier;

import com.nrecinos.backend.models.entities.event.Event;

import jakarta.persistence.Column;
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
}
