package com.computation.rest.exception.mapper;

public class ResultNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String expMessage;

	public ResultNotFoundException(String expMessage) {
		this.setExpMessage(expMessage);
	}

	public String getExpMessage() {
		return expMessage;
	}

	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}

}
