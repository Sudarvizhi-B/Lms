package com.cg.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
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


	public Address(int addressId, String address1, String address2, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
}
