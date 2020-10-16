package com.cognizant.microcredentials.fileclaims.exception;

public class InvalidClaimException extends ServiceException{
	private static final long serialVersionUID = 1L;

	public InvalidClaimException(String msg) {
		super(msg);
	}

}
