package com.nrecinos.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.sponsor.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer>{
	Sponsor findOneById(Integer id);
    List<Sponsor> findAllByEventId(Integer eventId);
}
