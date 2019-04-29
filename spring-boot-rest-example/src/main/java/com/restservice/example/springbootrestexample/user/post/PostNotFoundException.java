package com.restservice.example.springbootrestexample.user.post;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {
	
	public PostNotFoundException(String message)
	{
		super(message);
	}

}
