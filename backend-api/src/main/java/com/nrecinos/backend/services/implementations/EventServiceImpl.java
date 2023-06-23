package com.nrecinos.backend.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrecinos.backend.models.dtos.event.CreateEventDto;
import com.nrecinos.backend.models.dtos.event.EventInfoDto;
import com.nrecinos.backend.models.dtos.event.UpdateEventDto;
import com.nrecinos.backend.models.entities.event.Event;
import com.nrecinos.backend.repositories.EventRepository;
import com.nrecinos.backend.services.EventService;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public EventInfoDto create(CreateEventDto createCategoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event save(Event category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventInfoDto> findAll() {
		List<Event> events = eventRepository.findAll();
		/*if (events.size() == 0) {
			return new ArrayList<>();
		}*/
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
	public EventInfoDto update(Integer code, UpdateEventDto updateEventDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventInfoDto serializeEvent(Event event) {
		return new EventInfoDto(event.getId(), event.getTitle(), event.getDescription(), event.getDate(), event.getHour(),event.getDuration(),event.getAssistantsCapacity());
	}

}
