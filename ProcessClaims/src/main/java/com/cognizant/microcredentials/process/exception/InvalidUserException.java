package com.cognizant.microcredentials.process.exception;

public class InvalidUserException extends ServiceException{
	
	private static final long serialVersionUID = 1L;

	public InvalidUserException(String msg) {
		super(msg);
	}

}
