package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.tier.CreateTierDto;
import com.nrecinos.backend.models.dtos.tier.TierInfoDto;
import com.nrecinos.backend.models.dtos.tier.UpdateTierDto;
import com.nrecinos.backend.models.entities.tier.Tier;

public interface TierService {
	TierInfoDto create(CreateTierDto createCategoryDto);
	Tier save(Tier category);
	List<Tier> findAll();
	TierInfoDto findOne(Integer code);
	TierInfoDto update(Integer code, UpdateTierDto updateCategoryDto);
	void delete(Integer code);
}
