package com.Qlik.project.palindrome.palindromeservice.service;

import com.Qlik.project.palindrome.palindromeservice.service.exception.MessageNotFoundException;
import com.Qlik.project.palindrome.palindromeservice.service.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This is the service/DAO class. 

@Component
public class MessageServiceClass implements IMessageService {
//	
//	private static List<Message> message = new ArrayList<>();
//
//	// In static, we can define of what we want in out data-set.
//	
//	//private long id;
////	private Date messageCreated;
////	private Date messageLastModified;
////	private String message;
////	private boolean isPalindrome;
//	
//	static {
//		message.add(new Message("abba"));
//		message.add(new Message("dabba"));
//		message.add(new Message("jabba"));
//	}
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public long createMessage(String textMessage) {
		/*
		 * This is the main logic for POST/creating a new record by the User. We are
		 * creating the message, and saving it in the db using save()
		 */

		Message msg = new Message(textMessage);
		msg.setPalindrome(isPalindrome(msg));
		msg.setMessageCreated(new Date());
		msg.setMessageLastModified(msg.getMessageCreated());
		messageRepository.save(msg);
		return msg.getId();
	}

	public boolean isPalindrome(String msg) {

		/* Main business logic to check if the message is palidrome or not. */
		/* To make the string non case-sensitive */

		msg = msg.toLowerCase();

		/* Edge case - to check if the length of string is < 2 */

		if (msg.length() < 2) {
			return true;
		}

		char[] message = msg.toCharArray();
		int len = message.length;

		for (int i = 0, j = len - 1; i < j; i++, j--) {
			if (message[i] != message[j]) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Message retrieveMessage(long messageId) {
		/* findById is used from CrudRepository repository to get message by ID. */

		Optional<Message> message = messageRepository.findById(messageId);

		/* Message not present check.. */
		if (!message.isPresent()) {
			throw new MessageNotFoundException(messageId);
		}

		return message.get();
	}

	@Override
	public Message updateMessage(long messageId, String text) {
		// Try to find a message by ID, if not present, return null.

		Message msg = messageRepository.findById(messageId).orElse(null);
		if (msg == null) {
			throw new MessageNotFoundException(messageId);
		}
		/*
		 * Update the message with the new text that is passed. Set the last updated
		 * date for the message Check if it's Palindrome or not. Return the message
		 * object.
		 */

		msg.setMessage(text);
		msg.setPalindrome(isPalindrome(msg));
		msg.setMessageLastModified(new Date());
		messageRepository.save(msg);

		return msg;
	}

	@Override
	public String deleteMessage(long messageId) {
		/* Delete message when passed an ID */

		messageRepository.deleteById(messageId);
		return String.format("Message %s was deleted", messageId);
	}

	@Override
	public Iterable<Message> retrieveAllMessages() {
		/* Will iterate over the data-base to get all the messages */

		return messageRepository.findAll();
	}

	@Override
	public boolean isPalindrome(Message message) {

		// This method will check if the message-text is palindrome or not.
		// The message object will be passed as parameter from which we will get the
		// actual
		// text message to check if it's a palindrome.
		// The isPalindrome method infers method overwriting,
		// where we previously pass the actual text and here we pass the message object
		// which contains the text.

		if (message == null) {
			throw new MessageNotFoundException(message.getId());
		}
		boolean isPalindrome = isPalindrome(message.getMessage()); // Get the text from message object.
		message.setPalindrome(isPalindrome); // after checking it will set the value to true/false.
		messageRepository.save(message);
		return isPalindrome;

	}
}
