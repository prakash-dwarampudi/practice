package com.practice.core.rest;

import java.util.Date;

public class Message {

	private int id;
	private String message;
	private String author;
	private Date created;
	
	public Message(){}

	public Message(int id, String message, String author, Date created) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(this.getId()).append("\n").append("author= ").append(this.getAuthor()).append("\n")
				.append("message = ").append(this.getMessage()).append("\n");
		return sb.toString();
	}

}
