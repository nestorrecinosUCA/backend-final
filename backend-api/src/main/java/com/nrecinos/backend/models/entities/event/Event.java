package com.nrecinos.backend.models.entities.event;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.involved.Involved;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.models.entities.tier.Tier;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.models.entities.users_roles_role.UsersXRoles;
import com.nrecinos.backend.models.entities.voucher.Voucher;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "event", schema = "public")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@ToString.Exclude
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
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
	
	public Event(String title, String description, Date date, String hour, Float duration,
			Integer assistants, Integer assistantsCapacity, User user, Category category, Boolean isActive, String image) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.hour = hour;
		this.duration = duration;
		this.isActive = isActive;
		this.assistants = assistants;
		this.assistantsCapacity = assistantsCapacity;
		this.user = user;
		this.category = category;
		this.image = image;
	}
}
