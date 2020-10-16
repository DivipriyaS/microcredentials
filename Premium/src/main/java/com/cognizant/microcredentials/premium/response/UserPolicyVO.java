package com.cognizant.microcredentials.premium.response;

import java.sql.Date;

import com.cognizant.microcredentials.premium.entity.Policy;

public class UserPolicyVO {
	public UserPolicyVO() {

	}

	public UserPolicyVO(Policy policy) {
		super();
		this.policyName = policy.getPolicyName();
		this.policyNumber = String.valueOf(policy.getPolicyNumber());
		this.totalPolicyAmount = policy.getTotalAmount();
		this.premiumAmount = policy.getDueAmount();
		this.dueDate = policy.getDueDate();
	}

	private String policyName;
	private String policyNumber;
	private double totalPolicyAmount;
	private double premiumAmount;
	private Date dueDate;

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getTotalPolicyAmount() {
		return totalPolicyAmount;
	}

	public void setTotalPolicyAmount(double totalPolicyAmount) {
		this.totalPolicyAmount = totalPolicyAmount;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


}
