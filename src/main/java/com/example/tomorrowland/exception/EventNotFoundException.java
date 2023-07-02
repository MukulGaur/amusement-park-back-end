package com.example.tomorrowland.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public EventNotFoundException(Long id) {
		super("No record found for the the Event Id: " + id);
	}

}