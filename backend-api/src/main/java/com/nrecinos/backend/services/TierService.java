package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.tier.CreateTierDto;
import com.nrecinos.backend.models.dtos.tier.TierInfoDto;
import com.nrecinos.backend.models.dtos.tier.UpdateTierDto;
import com.nrecinos.backend.models.entities.tier.Tier;

public interface TierService {
	TierInfoDto create(CreateTierDto createTierDto);
	Tier save(Tier tier);
	List<TierInfoDto> findAll(Integer id);
	TierInfoDto findOne(Integer code);
	TierInfoDto update(Integer code, UpdateTierDto updateTierDto);
	void delete(Integer code);
	TierInfoDto serializeTierInfoDto(Tier tier);
}
