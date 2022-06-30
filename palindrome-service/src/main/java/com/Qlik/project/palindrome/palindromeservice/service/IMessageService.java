package com.Qlik.project.palindrome.palindromeservice.service;

import com.Qlik.project.palindrome.palindromeservice.service.model.Message;

public interface IMessageService {

	long createMessage(String textMessage);

	Message retrieveMessage(long messageId);

	Message updateMessage(long messageId, String text);

	String deleteMessage(long messageId);

	Iterable<Message> retrieveAllMessages();

	boolean isPalindrome(Message message);

}
