package com.cognizant.microcredentials.process.exception;

import com.cognizant.microcredentials.process.response.ErrorResponse;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	private ErrorResponse error;
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(ErrorResponse error) {
		this.error= error;
	}

	public ErrorResponse getError() {
		return error;
	}

}
