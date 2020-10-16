package com.cognizant.microcredentials.process.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "policydetails", schema = "mc")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POLICY_ID")
	private int policyId;
	@Column(name = "POLICY_NUMBER")
	private long policyNumber;
	@Column(name = "POLICY_NAME")
	private String policyName;
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	@ManyToOne
	@JoinColumn(name = "USR_UNIQUE_ID")
	private User user;
	@Column(name = "TOTAL_PREMIUM_AMOUNT")
	private Double totalAmount;
	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;
	@Column(name = "DUE_DATE")
	private Date dueDate;
	@Column(name = "PAID_AMOUNT")
	private Double paidAmount;
	@Column(name = "PREMIUM_DURATION")
	private int premiumDuration;

	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	Set<Transaction> transaction;

	@OneToMany(mappedBy = "claimPolicy", cascade = CascadeType.ALL)
	Set<Claims> claims;

	public Policy() {

	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getPremiumDuration() {
		return premiumDuration;
	}

	public void setPremiumDuration(int premiumDuration) {
		this.premiumDuration = premiumDuration;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Set<Claims> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claims> claims) {
		this.claims = claims;
	}

}
