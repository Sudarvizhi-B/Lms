package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reader {
	
	@Id
	private int id;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String email;
	
	//Constructors
	public Reader(){}
	public Reader(int id,String password, String firstName,String lastName,String mobileNo, String email)
	{
		this.id=id;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.mobileNo=mobileNo;
		this.email=email;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Readers [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}

}
