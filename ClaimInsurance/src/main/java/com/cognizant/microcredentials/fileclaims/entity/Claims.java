package com.cognizant.microcredentials.fileclaims.entity;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cognizant.microcredentials.fileclaims.request.ClaimRequest;

@Entity
@Table (name = "claimDetails", schema="mc")
public class Claims {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimId;
	@ManyToOne
	@JoinColumn (name="POLICY_ID")
	private Policy claimPolicy;
	@Column (name ="CLAIM_REASON")
	private String claimReason;
	@Column (name="CLAIM_AMOUNT")
	private double claimAmount;
	@Column (name="CLAIM_DATE")
	private Date claimDate;
	@Column (name ="ADDITONAL_COMMENTS")
	private String additonalComments;
	@Column(name="CLAIM_STATUS")
	private String claimsStatus;
	@Column (name="PROCESS_DATE")
	private Date processDate;
	@Column (name="PROCESS_COMMENTS")
	private String processComments;
	@Column (name="PROOF_DOC")
	private Blob proofDoc;
	public Claims() {
	}
	public int getClaimId() {
		return claimId;
	}
	
	public Blob getProofDoc() {
		return proofDoc;
	}
	public void setProofDoc(Blob proofDoc) {
		this.proofDoc = proofDoc;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public Policy getClaimPolicy() {
		return claimPolicy;
	}
	public void setClaimPolicy(Policy claimPolicy) {
		this.claimPolicy = claimPolicy;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public String getAdditonalComments() {
		return additonalComments;
	}
	public void setAdditonalComments(String additonalComments) {
		this.additonalComments = additonalComments;
	}
	public String getClaimsStatus() {
		return claimsStatus;
	}
	public void setClaimsStatus(String claimsStatus) {
		this.claimsStatus = claimsStatus;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public String getProcessComments() {
		return processComments;
	}
	public void setProcessComments(String processComments) {
		this.processComments = processComments;
	}
	public Claims(Policy claimPolicy, ClaimRequest request, Blob file) {
		super();
		
		long millis=System.currentTimeMillis();  
	    Date date=new Date(millis);  
		this.claimPolicy = claimPolicy;
		this.claimReason = request.getClaimReason();
		this.claimAmount = request.getClaimAmount();
		this.claimDate = date;
		this.additonalComments = request.getAdditonalComments();
		this.claimsStatus ="Submitted";
		this.proofDoc = file;
	}
	public Claims(Policy claimPolicy, ClaimRequest request) {
		super();
		
		long millis=System.currentTimeMillis();  
	    Date date=new Date(millis);  
		this.claimPolicy = claimPolicy;
		this.claimReason = request.getClaimReason();
		this.claimAmount = request.getClaimAmount();
		this.claimDate = date;
		this.additonalComments = request.getAdditonalComments();
		this.claimsStatus ="Submitted";
	}
	
}
