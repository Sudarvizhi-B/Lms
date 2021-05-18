package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Publishers {

	@Id
	private int publisherId;
	@NonNull
	private String publisherName;
	@NonNull
	private String contactno;
	@NonNull
	private String email;
	@NonNull
	private String address1;
	@NonNull
	private String address2;
	@NonNull
	private String city;
	@NonNull
	private String state;
	private int pincode;

}
