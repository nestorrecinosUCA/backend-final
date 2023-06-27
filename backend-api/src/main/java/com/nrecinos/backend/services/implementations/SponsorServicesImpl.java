package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.sponsor.CreateSponsorDto;
import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.sponsor.UpdateSponsorDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.repositories.EventRepository;
import com.nrecinos.backend.repositories.SponsorRepository;
import com.nrecinos.backend.services.SponsorService;

@Service
public class SponsorServicesImpl implements SponsorService {
	@Autowired
	EventRepository eventRepository;

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Override
	public SponsorInfoDto create(CreateSponsorDto info) {
		Event event = eventRepository.findOneById(info.getEventId());
		Sponsor newSponsor = new Sponsor(
				info.getName(),
				event
		);
		
		Sponsor saveSponsor = this.save(newSponsor);
		SponsorInfoDto serializedSponsor = this.serializeSponsorInfoDto(saveSponsor);
		return serializedSponsor;
	}

	@Override
	public Sponsor save(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

	@Override
	public List<SponsorInfoDto> findAllByEventId(Integer id) {
		List<Sponsor> sponsors = sponsorRepository.findAllByEventId(id);
		List<SponsorInfoDto> serializedSponsors = sponsors
				.stream()
				.map(sponsor -> this.serializeSponsorInfoDto(sponsor))
				.toList();
		return serializedSponsors;
	}

	@Override
	public SponsorInfoDto findOne(Integer code) {
		Sponsor sponsor = sponsorRepository.findOneById(code);
		if(sponsor == null) {
			return null;
		}
		SponsorInfoDto sponsorInfo= this.serializeSponsorInfoDto(sponsor);
		return sponsorInfo;
	}

	@Override
	public SponsorInfoDto update(Integer code, UpdateSponsorDto updateSponsorDto) {
		Sponsor sponsor = sponsorRepository.findOneById(code);
		if(updateSponsorDto.getName() != null) {
			sponsor.setName(updateSponsorDto.getName());;
		}
		if(updateSponsorDto.getEventId() != null) {
			Event event = eventRepository.findOneById(updateSponsorDto.getEventId());
			sponsor.setEvent(event);
		}
		sponsorRepository.save(sponsor);
		SponsorInfoDto sponsorInfo= this.serializeSponsorInfoDto(sponsor);
		return sponsorInfo;
	}

	@Override
	public void delete(Integer code) {
		sponsorRepository.deleteById(code);
	}
	
	@Override
	public SponsorInfoDto serializeSponsorInfoDto(Sponsor sponsor) {
		return new SponsorInfoDto(sponsor.getId(), sponsor.getName(), sponsor.getEvent().getTitle(), sponsor.getEvent().getId());
	}

}
