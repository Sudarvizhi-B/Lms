package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@NotEmpty(message = "Name cannot be Empty")
	private String publisherName;
	@NonNull
	@Size(min=5,max=10)
	private String contactno;
	@NonNull
	@Email(message = "Email should be valid")
	private String email;
	@NonNull
	@NotEmpty
	private String address1;
	@NonNull
	@NotEmpty
	private String address2;
	@NonNull
	@NotEmpty
	private String city;
	@NonNull
	@NotEmpty
	private String state;
	@NotEmpty
	@Max(6)
	private int pincode;

}
