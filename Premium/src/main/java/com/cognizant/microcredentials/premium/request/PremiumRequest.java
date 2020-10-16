package com.cognizant.microcredentials.premium.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PremiumRequest {

	@NotNull(message = "UserId cannot be null")
	@NotEmpty(message = "UserId cannot be empty")
	private String userId;
	@NotNull(message = "ssn cannot be null")
	@NotEmpty(message = "ssn cannot be empty")
	private String ssn;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	@Override
	public String toString() {
		return "PremiumRequest [userId=" + userId + ", ssn=" + ssn + "]";
	}

}
