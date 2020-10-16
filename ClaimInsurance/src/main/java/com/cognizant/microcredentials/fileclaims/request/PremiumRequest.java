package com.cognizant.microcredentials.fileclaims.request;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PremiumRequest {

	@NotNull(message = "UserId cannot be null")
	@NotEmpty(message = "UserId cannot be empty")
	private String userId;
	@NotNull(message = "ssn cannot be null")
	@NotEmpty(message = "ssn cannot be empty")
	private String ssn;
	private Date dateOfBirth;


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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public PremiumRequest(ClaimRequest claimRequest) {
		super();
		this.userId = claimRequest.getUserId();
		this.ssn = claimRequest.getSsn();
	}


}
