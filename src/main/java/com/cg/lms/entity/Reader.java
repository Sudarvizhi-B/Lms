package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Entity
@Inheritance
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
	
	@Id
	private int id;
	@NonNull
	private String password;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	@Size(min=10, message="contact number should have 10 numberics")
	private String mobileNo;
	@NonNull
	private String email;
	
}
