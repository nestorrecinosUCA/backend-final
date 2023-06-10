package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.sponsor.CreateSponsorDto;
import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;

public interface SponsorService {
	SponsorInfoDto create(CreateSponsorDto createCategoryDto);
	Sponsor save(Sponsor category);
	List<Sponsor> findAll();
	SponsorInfoDto findOne(Integer code);
	SponsorInfoDto update(Integer code);
	void delete(Integer code);
}
