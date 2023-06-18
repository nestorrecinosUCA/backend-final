package com.nrecinos.backend.models.entities.event;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.involved.Involved;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.models.entities.tier.Tier;
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
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "hour")
	private String hour;
	
	@Column(name = "duration")
	private Float duration;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "assistants")
	private Integer assistants;
	
	@Column(name = "assistants_capacity")
	private Integer assistantsCapacity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@ToString.Exclude
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	@ToString.Exclude
	private Category category;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private List<Sponsor> sponsors;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private List<Involved> involved;
	
	@OneToMany(mappedBy = "event")
	@JsonIgnore
	private List<Tier> tiers;
}
