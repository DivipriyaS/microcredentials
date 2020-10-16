package com.cognizant.microcredentials.fileclaims.request;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionRequest {

	@NotNull @NotEmpty(message="UserId cannot be null or empty")
	private String userId;
	private int policyNumber;
	//@Pattern
	private double transactionAmount;
	private String bankName;
	private String cardNumber;
	private Date cardExpiry;
	private String cvv;
	private String cardType;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
