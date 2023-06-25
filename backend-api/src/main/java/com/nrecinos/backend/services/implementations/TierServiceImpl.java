package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.tier.CreateTierDto;
import com.nrecinos.backend.models.dtos.tier.TierInfoDto;
import com.nrecinos.backend.models.dtos.tier.UpdateTierDto;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.models.entities.tier.Tier;
import com.nrecinos.backend.repositories.TierRepository;
import com.nrecinos.backend.services.TierService;

@Service
public class TierServiceImpl implements TierService{

	@Autowired
	private TierRepository tierRepository;
	
	@Override
	public TierInfoDto create(CreateTierDto info) {
		Tier newTier = new Tier(
				info.getName(), 
				info.getDescription(), 
				info.getCapacity(), 
				info.getPrice(),
				info.getSold(), 
				info.getIsSoldOut(), 
				info.getEvent());
		Tier saveTier = this.save(newTier);
		
		return null;
	}
	
	@Override
	public TierInfoDto serializeTierInfoDto(Tier tier) {
		return new TierInfoDto(tier.getName(), tier.getDescription(), tier.getCapacity(),
				tier.getPrice(), tier.getSold(), tier.getIsSoldOut(), tier.getEvent());
	}

	@Override
	public Tier save(Tier tier) {	
		return tierRepository.save(tier);
	}

	@Override
	public List<Tier> findAll() {
		return tierRepository.findAll();
	}

	@Override
	public TierInfoDto findOne(Integer code) {
		Tier tier = tierRepository.findOneById(code);
		if(tier == null) {
			return null;
		}
		TierInfoDto tierInfo= this.serializeTierInfoDto(tier);
		return tierInfo;

	}

	@Override
	public TierInfoDto update(Integer code, UpdateTierDto info) {
		TierInfoDto tierDto = this.findOne(code);
		if(tierDto == null) {
			return null;
		}
		Tier tier = new Tier(
				info.getName(), 
				info.getDescription(), 
				info.getCapacity(), 
				info.getPrice(),
				info.getSold(), 
				info.getIsSoldOut(), 
				info.getEvent());
		
		tierRepository.save(tier);
		TierInfoDto tierInfo= this.serializeTierInfoDto(tier);
		return tierInfo;
	}

	@Override
	public void delete(Integer code) {
		tierRepository.deleteById(code);
		
	}

}
