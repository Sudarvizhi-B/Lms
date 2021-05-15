package com.cg.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {
	
	@Id
	private int addressId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int pincode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private Users users;

	public Address() {}

	public Address(int addressId, String address1, String address2, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	@JsonBackReference
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	// ToString
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode +"]";
	}
}
