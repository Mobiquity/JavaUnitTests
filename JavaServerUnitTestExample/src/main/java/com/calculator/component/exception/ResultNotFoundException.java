package com.calculator.component.exception;

public class ResultNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResultNotFoundException(String message) {
		super(message);
	}
}
