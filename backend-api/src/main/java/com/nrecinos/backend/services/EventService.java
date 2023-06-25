package com.nrecinos.backend.services;

import java.util.List;

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.event.UpdateEventDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.user.User;

public interface EventService {
	EventInfoDto create(CreateEventDto createCategoryDto, User user, Category category);
	Event save(Event category);
	List<EventInfoDto> findAll();
	EventInfoDto findOne(Integer code);
	EventInfoDto update(Integer code, UpdateEventDto updateEventDto);
	void updateStatus(Integer code);
	EventInfoDto serializeEvent(Event event);
}
