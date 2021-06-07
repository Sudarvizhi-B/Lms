package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Users {
	
	@Id
	private int userId;
	private Date dateOfBirth;
	private Date subscriptionDate;
	private Date subExpireDate;
	@NotEmpty
	@Size(min = 2, message = "subscriptionStatus should have atleast 2 char")
	private String subscriptionStatus;

	@OneToOne(mappedBy = "users")
	private Address address;
	

	// Constructors
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", dateOfBirth=" + dateOfBirth + ", subscriptionDate=" + subscriptionDate
				+ ", subExpireDate=" + subExpireDate + ", subscriptionStatus=" + subscriptionStatus + "]";
	}
	
}
