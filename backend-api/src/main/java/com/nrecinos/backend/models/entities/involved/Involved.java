package com.nrecinos.backend.models.entities.involved;

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
@Table(name = "involved")
public class Involved {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "type")
	String type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eventId")
	@ToString.Exclude
	private Event event;
}
