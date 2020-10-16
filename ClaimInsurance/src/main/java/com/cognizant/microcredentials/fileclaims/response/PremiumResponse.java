package com.cognizant.microcredentials.fileclaims.response;

import java.util.List;

import com.cognizant.microcredentials.fileclaims.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_DEFAULT)
public class PremiumResponse {

	private String userId;
	private String userName;
	private String emailId;
	private List<UserPolicyVO> userPolicy;
	private ErrorResponse error;
	
	public PremiumResponse() {
		
	}


	public ErrorResponse getError() {
		return error;
	}


	public void setError(ErrorResponse error) {
		this.error = error;
	}


	public PremiumResponse(User user) {
		this.userId = user.getUsrId();
		this.userName = user.getFirstName() + " " + user.getLastName();
		this.emailId = user.getEmailAddress();
	}

	public String getUserId() {
		return userId;
	}

	public List<UserPolicyVO> getUserPolicy() {
		return userPolicy;
	}

	public void setUserPolicy(List<UserPolicyVO> userPolicy) {
		this.userPolicy = userPolicy;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}
