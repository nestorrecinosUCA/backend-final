package com.nrecinos.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.event.UpdateEventDto;
import com.nrecinos.backend.models.entities.category.Category;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.CategoryRepository;
import com.nrecinos.backend.repositories.EventRepository;
import com.nrecinos.backend.services.EventService;
import com.nrecinos.backend.services.UserService;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public EventInfoDto create(CreateEventDto createEventDto, User user, Category category) {
		Event event = new Event(
				createEventDto.getTitle(),
				createEventDto.getDescription(),
				createEventDto.getDate(),
				createEventDto.getHour(),
				createEventDto.getDuration(),
				0,
				createEventDto.getAssistantsCapacity(),
				user,
				category,
				true,
				createEventDto.getImage());
		Event savedEvent = this.save(event);
		return this.serializeEvent(savedEvent);
	}

	@Override
	public Event save(Event event) {
		Event savedEvent = eventRepository.save(event);
		return savedEvent;
	}

	@Override
	public List<EventInfoDto> findAll(String status) {
		List<Event> events = null;
		if (status.equals("all")) {
			events = eventRepository.findAll();	
		} else {
			Boolean isVerified = status.equals("active") ? true : false;
			events = eventRepository.findAllByIsActive(isVerified); 
		}
		List<EventInfoDto> eventsSerialized = events.stream()
				.map(event -> this.serializeEvent(event))
				.toList();
		return eventsSerialized;
	}

	@Override
	public EventInfoDto findOne(Integer code) {
		Event event = eventRepository.findOneById(code);
        if (event != null) {
            return this.serializeEvent(event);
        } else {
            return null;
        }
	}

	@Override
	public EventInfoDto update(Integer id, UpdateEventDto updateEventDto) {
		Event eventToUpdate = eventRepository.findOneById(id);
		if (updateEventDto.getTitle() != null) {
            eventToUpdate.setTitle(updateEventDto.getTitle());
        }
        if (updateEventDto.getDescription() != null) {
            eventToUpdate.setDescription(updateEventDto.getDescription());
        }
        if (updateEventDto.getDate() != null) {
            eventToUpdate.setDate(updateEventDto.getDate());
        }
        if (updateEventDto.getHour() != null) {
            eventToUpdate.setHour(updateEventDto.getHour());
        }
        if (updateEventDto.getDuration() != null) {
            eventToUpdate.setDuration(updateEventDto.getDuration());
        }
        if (updateEventDto.getAssistantsCapacity() != null) {
            eventToUpdate.setAssistantsCapacity(updateEventDto.getAssistantsCapacity());
        }
        if (updateEventDto.getImage() != null) {
        	eventToUpdate.setImage(updateEventDto.getImage());
        }
        if (updateEventDto.getCategoryId() != null) {
        	Category category = categoryRepository.findOneById(updateEventDto.getCategoryId());
        	eventToUpdate.setCategory(category);
        }
		Event savedEvent = this.save(eventToUpdate);
		return this.serializeEvent(savedEvent);
	}

	@Override
	public void updateStatus(Integer id) {
		Event event = eventRepository.findOneById(id);
		System.out.println("Here");
		if(event.getIsActive() == true) {
			event.setIsActive(false);
		} else {
			event.setIsActive(true);
		}
		this.save(event);
	}

	@Override
	public EventInfoDto serializeEvent(Event event) {
		return new EventInfoDto(
				event.getId(),
				event.getTitle(),
				event.getDescription(),
				event.getDate(),
				event.getHour(),
				event.getDuration(),
				event.getAssistantsCapacity(),
				event.getImage(),
				userService.serializeUserInfoDto(event.getUser())
				);
	}

}
