package com.nrecinos.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrecinos.backend.models.entities.event.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{
	Event findOneById(Integer id);
	List<Event> findAllByIsActive(Boolean isActive);
}
