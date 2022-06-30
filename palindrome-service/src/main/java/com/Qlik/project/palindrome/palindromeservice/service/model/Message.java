package com.Qlik.project.palindrome.palindromeservice.service.model;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;

// Data Model for Messages. 

@Entity
public class Message {

	@Id
	@GeneratedValue()

	private long id;
	private Date messageCreated;
	private Date messageLastModified;
	private String message;
	private boolean isPalindrome;

	// Constructor
	public Message(String message) {
		super();
//		this.id = id;
//		this.messageCreated = messageCreated;
//		this.messageLastModified = messageLastModified;
		this.message = message;
// 		this.isPalindrome = isPalindrome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMessageCreated() {
		return messageCreated;
	}

	public void setMessageCreated(Date messageCreated) {
		this.messageCreated = messageCreated;
	}

	public Date getMessageLastModified() {
		return messageLastModified;
	}

	public void setMessageLastModified(Date messageLastModified) {
		this.messageLastModified = messageLastModified;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isPalindrome() {
		return isPalindrome;
	}

	public void setPalindrome(boolean isPalindrome) {
		this.isPalindrome = isPalindrome;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", messageCreated=" + messageCreated + ", messageLastModified="
				+ messageLastModified + ", message=" + message + ", isPalindrome=" + isPalindrome + "]";
	}

}
