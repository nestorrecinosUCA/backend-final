package com.nrecinos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.event.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{
	Event findOneById(Integer id);

}
