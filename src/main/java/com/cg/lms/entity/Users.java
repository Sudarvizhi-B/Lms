package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

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
}
