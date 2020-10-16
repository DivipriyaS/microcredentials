package com.cognizant.microcredentials.process.exception;

import java.util.Set;

public class ErrorDetails {
	
	private int code;
	
	private Set message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Set getMessage() {
		return message;
	}

	public void setMessage(Set<String> message) {
		this.message = message;
	}
	
	

}
