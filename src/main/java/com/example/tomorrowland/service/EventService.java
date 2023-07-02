package com.example.tomorrowland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tomorrowland.entity.Event;
import com.example.tomorrowland.exception.EventNotFoundException;
import com.example.tomorrowland.repository.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }
    
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    
    public Event updateEvent(Long id, Event event) {
    	Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        
        existingEvent.setName(event.getName());
        existingEvent.setCategory(event.getCategory());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setPrice(event.getPrice());
        return eventRepository.save(existingEvent);
    }
    
    public void deleteEvent(Long id) {
    	eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        eventRepository.deleteById(id);
    }

}
