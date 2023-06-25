package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.sponsor.CreateSponsorDto;
import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.sponsor.UpdateSponsorDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.repositories.SponsorRepository;
import com.nrecinos.backend.services.SponsorService;

@Service
public class SponsorServicesImpl implements SponsorService {

	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Override
	public SponsorInfoDto create(CreateSponsorDto info) {
		Sponsor newSponsor = new Sponsor(
				info.getName(),
				info.getEvent());
		
		Sponsor saveSponsor = this.save(newSponsor);
		SponsorInfoDto sponsorInfo = this.serializeSponsorInfoDto(saveSponsor);
		
		return sponsorInfo;
	}

	@Override
	public Sponsor save(Sponsor sponsor) {
		// TODO Auto-generated method stub
		return sponsorRepository.save(sponsor);
	}

	@Override
	public List<Sponsor> findAll() {
		return sponsorRepository.findAll();
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
		SponsorInfoDto sponsorDto = this.findOne(code);
		if(sponsorDto == null) {
			return null;
		}
		Sponsor sponsor = new Sponsor (
				updateSponsorDto.getName(),
				updateSponsorDto.getEvent());
		
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
		return new SponsorInfoDto(sponsor.getName(), sponsor.getEvent());
	}

}
