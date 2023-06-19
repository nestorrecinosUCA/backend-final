package com.nrecinos.backend.models.entities.tickets_tiers_tier;
import com.nrecinos.backend.models.entities.ticket.Ticket;
import com.nrecinos.backend.models.entities.tier.Tier;
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
@Table(name = "tickets_tiers_tier")
public class TicketsXTiers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tierId")
	@ToString.Exclude
	private Tier tier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticketId")
	@ToString.Exclude
	private Ticket ticket;	public TicketsXTiers(Tier tier, Ticket ticket) {		super();		this.tier = tier;		this.ticket = ticket;	}
}
