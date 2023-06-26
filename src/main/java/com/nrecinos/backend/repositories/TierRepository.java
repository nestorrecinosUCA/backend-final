package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.tier.Tier;

public interface TierRepository extends JpaRepository<Tier, Integer> {
	Tier findOneById(Integer id);

}
