package com.example.tomorrowland.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long id) {
		super("No record found for the the User Id: " + id);
	}

}
