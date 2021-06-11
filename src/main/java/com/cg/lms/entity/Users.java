package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue
	private int userId;

	/*
	 * Password Validation
	 */
	@NotEmpty(message = "Please Enter your Password")
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Password is Invalid")
	@Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters")
	private String password;

	/**
	 * FirstName Validation
	 */
	@NotEmpty(message = "Please Enter your FirstName")
	@Pattern(regexp = "[A-Za-z]+", message = "FirstName is Invalid")
	@Size(min = 2, max = 10, message = "Firstname should have atleast 7 characters not less than 10 characters")
	private String firstname;

	/**
	 * LastName Validation
	 */
	@NotEmpty(message = "Please Enter your LastName")
	@Pattern(regexp = "[A-Za-z]+", message = "LastName is Invalid")
	@Size(min = 1, max = 10, message = "Lastnmae should have atleast 7 characters not less than 10 characters")
	private String lastname;

	/**
	 * MobileNumber Validation
	 */
	@NotEmpty(message = "Please Enter Your EmailId")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number is Invalid")
	//@Size(min = 10, max = 10, message = "Mobile Number less than 10 is Invalid")
	private String mobileNumber;

	/*
	 * Email Validation
	 */
	@Email
	@NotEmpty(message = "Please Enter Your Email Id")
	private String email;
	private Date dateOfBirth;
	private Date subscriptionDate;
	private Date subExpireDate;

	private String subscriptionStatus;
	@JsonIgnore
	@OneToOne(mappedBy = "users")
	private Address address;

	public Users(int userId,
			@NotEmpty(message = "Please Enter your Password") @Pattern(regexp = "[A-Za-z0-9]+", message = "Password is Invalid") @Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters") String password,
			@NotEmpty(message = "Please Enter your FirstName") @Pattern(regexp = "[A-Za-z]+", message = "FirstName is Invalid") @Size(min = 2, max = 10, message = "Firstname should have atleast 7 characters not less than 10 characters") String firstname,
			@NotEmpty(message = "Please Enter your LastName") @Pattern(regexp = "[A-Za-z]+", message = "LastName is Invalid") @Size(min = 1, max = 10, message = "Lastnmae should have atleast 7 characters not less than 10 characters") String lastname,
			@NotEmpty(message = "Please Enter Your EmailId") @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number is Invalid") @Size(min = 10, max = 10, message = "Mobile Number less than 10 is Invalid") String mobileNumber,
			@Email @NotEmpty(message = "Please Enter Your Email Id") String email, Date dateOfBirth,
			Date subscriptionDate, Date subExpireDate)
			//@NotEmpty @Size(min = 2, message = "subscriptionStatus should have atleast 2 char") String subscriptionStatus) 
			{
		super();
		this.userId = userId;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.subscriptionDate = subscriptionDate;
		this.subExpireDate = subExpireDate;
		this.subscriptionStatus = subscriptionStatus;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", mobileNumber=" + mobileNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", subscriptionDate=" + subscriptionDate + ", subExpireDate=" + subExpireDate
				+ ", subscriptionStatus=" + subscriptionStatus + "]";
	}

}
