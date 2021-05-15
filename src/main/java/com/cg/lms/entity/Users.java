package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users {
	
	@Id
	private int userId;
	private Date dateOfBirth;
	private Date subscriptionDate;
	private Date subExpireDate;
	private String subscriptionStatus;

	@OneToOne(mappedBy = "users")
	private Address address;

	// Constructors
	public Users() {}

	public Users(int userId, Date dateOfBirth, Date subscriptionDate, Date subExpireDate, String subscriptionStatus) {
		super();
		this.userId = userId;
		this.dateOfBirth = dateOfBirth;
		this.subscriptionDate = subscriptionDate;
		this.subExpireDate = subExpireDate;
		this.subscriptionStatus = subscriptionStatus;

	}

	public Users(int userId, Date dateOfBirth, Date subscriptionDate, Date subExpireDate, String subscriptionStatus,
			Address address) {
		super();
		this.userId = userId;
		this.dateOfBirth = dateOfBirth;
		this.subscriptionDate = subscriptionDate;
		this.subExpireDate = subExpireDate;
		this.subscriptionStatus = subscriptionStatus;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getSubExpireDate() {
		return subExpireDate;
	}

	public void setSubExpireDate(Date subExpireDate) {
		this.subExpireDate = subExpireDate;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	@JsonManagedReference
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", dateOfBirth=" + dateOfBirth + ", subscriptionDate=" + subscriptionDate
				+ ", subExpireDate=" + subExpireDate + ", subscriptionStatus=" + subscriptionStatus + ", address="
				+ address + "]";
	}
}
