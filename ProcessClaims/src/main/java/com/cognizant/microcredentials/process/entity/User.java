package com.cognizant.microcredentials.process.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema="mc")
public class User {

	@Id
	@Column(name = "USR_UNIQ_ID")
	private String usrId;
	@Column(name = "USR_LST_NM")
	private String lastName;
	@Column(name = "USR_FRST_NM")
	private String firstName;
	@Column(name = "SSN")
	private long ssn;
	@Column(name = "USR_EMAIL_ADDR_TXT")
	private String emailAddress;
	@Column(name = "USR_STATE_CODE")
	private String country;
	@Column(name = "USR_MARITIAL_STATUS")
	private char maritialStatus;
	@Column(name = "USR_GENDER")
	private char gender;
	@Column(name = "USR_ZIP")
	private long zip;
	@Column (name = "USR_DATE_OF_BIRTH")
	private Date dateOfBirth;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	Set<Policy> policies;

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}

	public User() {
	}
	
	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public char getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(char maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	
}
