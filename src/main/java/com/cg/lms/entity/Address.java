package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue
	private int addressId;
	private String address1;
	private String address2;
	@NotEmpty
	@Size(min = 2, message = "city should have atleast 2 char")
	private String city;
	private String state;
	private int pincode;

	@JsonIgnore
	@OneToOne
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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
