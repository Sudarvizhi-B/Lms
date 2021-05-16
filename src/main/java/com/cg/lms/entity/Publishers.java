package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publishers {

	@Id
	private int publisherId;
	private String publisherName;
	private String contactno;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int pincode;

	public Publishers() {}

	public Publishers(int publisherId, String publisherName, String contactno, String email, String address1,
			String address2, String city, String state, int pincode) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Publishers [publisherId=" + publisherId + ", publisherName=" + publisherName + ", contactno="
				+ contactno + ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
