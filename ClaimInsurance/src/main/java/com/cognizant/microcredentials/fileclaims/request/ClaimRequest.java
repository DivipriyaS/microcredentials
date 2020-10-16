package com.cognizant.microcredentials.fileclaims.request;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClaimRequest {

	@NotNull(message = "UserId cannot be null")
	@NotEmpty(message = "UserId cannot be empty")
	private String userId;
	@NotNull(message = "ssn cannot be null")
	@NotEmpty(message = "ssn cannot be empty")
	private String ssn;
	private String policyNumber;
	private double claimAmount;
	private String claimReason;
	private String additonalComments;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getAdditonalComments() {
		return additonalComments;
	}

	public void setAdditonalComments(String additonalComments) {
		this.additonalComments = additonalComments;
	}

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


}
