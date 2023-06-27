package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.sponsor.SponsorInfoDto;
import com.nrecinos.backend.models.dtos.tier.CreateTierDto;
import com.nrecinos.backend.models.dtos.tier.TierInfoDto;
import com.nrecinos.backend.models.dtos.tier.UpdateTierDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;
import com.nrecinos.backend.models.entities.tier.Tier;
import com.nrecinos.backend.repositories.EventRepository;
import com.nrecinos.backend.repositories.TierRepository;
import com.nrecinos.backend.services.TierService;

@Service
public class TierServiceImpl implements TierService{

	@Autowired
	private TierRepository tierRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public TierInfoDto create(CreateTierDto info) {
		Event event = eventRepository.findOneById(info.getEventId());
		Tier newTier = new Tier(
				info.getName(), 
				info.getDescription(), 
				info.getCapacity(), 
				info.getPrice(),
				0, 
				false, 
				event);
		Tier saveTier = this.save(newTier);
		return this.serializeTierInfoDto(saveTier);
	}
	
	@Override
	public TierInfoDto serializeTierInfoDto(Tier tier) {
		return new TierInfoDto(
				tier.getId(),
				tier.getName(),
				tier.getDescription(),
				tier.getCapacity(),
				tier.getPrice(),
				tier.getSold(),
				tier.getIsSoldOut(),
				tier.getEvent().getTitle(),
				tier.getEvent().getId()
				);
	}

	@Override
	public Tier save(Tier tier) {	
		return tierRepository.save(tier);
	}

	@Override
	public List<TierInfoDto> findAll(Integer id) {
		List<Tier> tiers = tierRepository.findAllByEventId(id);
		List<TierInfoDto> serializedTiers = tiers
				.stream()
				.map(tier -> this.serializeTierInfoDto(tier))
				.toList();
		return serializedTiers;
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
	public TierInfoDto update(Integer code, UpdateTierDto updateTierDto) {
		Tier tier = tierRepository.findOneById(code);
		if(tier == null) {
			return null;
		}
		if (updateTierDto.getName() != null) {
            tier.setName(updateTierDto.getName());
        }
        if (updateTierDto.getDescription() != null) {
            tier.setDescription(updateTierDto.getDescription());
        }
        if (updateTierDto.getCapacity() != null) {
            tier.setCapacity(updateTierDto.getCapacity());
        }
        if (updateTierDto.getPrice() != null) {
            tier.setPrice(updateTierDto.getPrice());
        }
        if (updateTierDto.getSold() != null) {
            tier.setSold(updateTierDto.getSold());
        }
        if (updateTierDto.getIsSoldOut() != null) {
            tier.setIsSoldOut(updateTierDto.getIsSoldOut());
        }
        if (updateTierDto.getEventId() != null) {
        	Event event = eventRepository.findOneById(updateTierDto.getEventId());
            tier.setEvent(event);
        }
		
		tierRepository.save(tier);
		TierInfoDto tierInfo= this.serializeTierInfoDto(tier);
		return tierInfo;
	}

	@Override
	public void delete(Integer code) {
		tierRepository.deleteById(code);
	}

}
