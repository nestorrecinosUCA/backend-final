package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.event.UpdateEventDto;
import com.nrecinos.backend.models.entities.event.Event;

public interface EventService {
	EventInfoDto create(CreateEventDto createCategoryDto);
	Event save(Event category);
	List<EventInfoDto> findAll();
	EventInfoDto findOne(Integer code);
	EventInfoDto update(Integer code, UpdateEventDto updateEventDto);
	void delete(Integer code);
	EventInfoDto serializeEvent(Event event);
}
