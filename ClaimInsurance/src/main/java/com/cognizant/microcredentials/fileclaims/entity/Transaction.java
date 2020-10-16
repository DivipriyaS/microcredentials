package com.cognizant.microcredentials.fileclaims.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cognizant.microcredentials.fileclaims.request.TransactionRequest;

@Entity
@Table(name="Transaction", schema="mc")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="POLICY_ID")
	private Policy policy;
	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;
	@Column(name="BANK_NAME")
	private String bankName;
	@Column(name="CARD_TYPE")
	private String cardType;
	@Column(name="CARD_EXPIRY_DATE")
	private Date cardExpiryDate;
	@Column(name="TRANS_STATUS")
	private String transStatus;
	@Column(name="TRANS_DATE")
	private Date paymentDate;
	@Column(name="CARD_NUMBER")
	private String cardNumber;
	@Column(name="CARD_CVV")
	private String cardCVV;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		 this.paymentDate = paymentDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	
	public Transaction() {
		
	}
	
	public Transaction(Policy policy, TransactionRequest request) {
		super();
		long millis=System.currentTimeMillis();  
	    Date date=new Date(millis);  
		this.policy = policy;
		this.transactionAmount = request.getTransactionAmount();
		this.bankName = request.getBankName();
		this.cardType = request.getCardType();
		this.cardExpiryDate = request.getCardExpiry();
		this.transStatus = "Paid";
		this.paymentDate= date;
		this.cardNumber = request.getCardNumber();
		this.cardCVV = request.getCvv();
	}
}
