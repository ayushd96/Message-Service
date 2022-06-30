package com.Qlik.project.palindrome.palindromeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Qlik.project.palindrome.palindromeservice.service.MessageServiceClass;
import com.Qlik.project.palindrome.palindromeservice.service.model.Message;

// This is the main controller class which will have API logic. 
// The controller class will call the DAO/service class for all CRUD ops. 

@RestController
public class MessageControllerClass {

	@Autowired
	private MessageServiceClass messageService;

	// GET -> Retrieve by ID

	@RequestMapping(method = RequestMethod.GET, path = "/message/{messageId}")
	public Message getMessage(@PathVariable long messageId) {
		return messageService.retrieveMessage(messageId);
	}

	// GET - Get all Messages

	@RequestMapping(method = RequestMethod.GET, path = "/message/all")
	public Iterable<Message> getMessage() {
		return messageService.retrieveAllMessages();
	}

	// GET - Check if the message is palindrome

	@RequestMapping(method = RequestMethod.GET, path = "/message/palin/{messageId}")
	public boolean getIsPalindrome(@PathVariable long messageId) {
		return messageService.retrieveMessage(messageId).isPalindrome();
	}
	
	// POST --> Create a message

	@PostMapping("/message/create-message")
	public long createMessage(@RequestBody String messageText) {
		return messageService.createMessage(messageText);
	}

	// DELETE --> delete a message

	@RequestMapping(method = RequestMethod.GET, path = "/message/delete/{messageId}")
	public String deleteMessage(@PathVariable long messageId) {
		messageService.deleteMessage(messageId);
		return String.format("The message has been deleted for id %s", messageId);
	}

	// PUT --> Update

	@RequestMapping(method = RequestMethod.PUT, path = "/message/update/{messageId}")
	public Message updateMessage(@PathVariable long messageId, @RequestBody String message) {
		return messageService.updateMessage(messageId, message);
	}

}
