package com.Qlik.project.palindrome.palindromeservice.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*If the message is not found, it will throw message not found exception with 404 code. */

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MessageNotFoundException extends RuntimeException {

	public MessageNotFoundException() {
		super();
	}

	public MessageNotFoundException(long messageId) {
		super(String.format("The message for the id:  %s not found ", messageId));
	}
}
