package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Entity
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
	@NotBlank
	private String firstName;
	@NonNull
	@NotBlank
	private String lastName;
	@NonNull
	@Size(min=10, max=10, message="contact number should have 10 numberic values")
	private String mobileNo;
	@Email
	@NonNull
	@NotBlank
	private String email;
	
}
