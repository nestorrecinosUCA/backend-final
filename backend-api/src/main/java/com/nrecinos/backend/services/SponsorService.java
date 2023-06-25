package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.sponsor.CreateSponsorDto;
import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.sponsor.UpdateSponsorDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;

public interface SponsorService {
	SponsorInfoDto create(CreateSponsorDto createSponsorDto);
	Sponsor save(Sponsor sponsor);
	List<Sponsor> findAll();
	SponsorInfoDto findOne(Integer code);
	SponsorInfoDto update(Integer code, UpdateSponsorDto updateSponsorDto);
	void delete(Integer code);
	SponsorInfoDto serializeSponsorInfoDto(Sponsor sponsor);
}
