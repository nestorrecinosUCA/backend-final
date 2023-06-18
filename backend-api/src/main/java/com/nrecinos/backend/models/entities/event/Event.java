package com.nrecinos.backend.models.entities.event;

import java.util.Date;

import com.nrecinos.backend.models.entities.user.User;

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
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "date")
	Date date;
	
	@Column(name = "hour")
	String hour;
	
	@Column(name = "duration")
	Float duration;
	
	@Column(name = "is_active")
	Boolean isActive;
	
	@Column(name = "assistants")
	Integer assistants;
	
	@Column(name = "assistants_capacity")
	Integer assistantsCapacity;
	// TODO Update relationships
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@ToString.Exclude
	private User user;

	Integer tierId;
	Integer categoryId;
}
