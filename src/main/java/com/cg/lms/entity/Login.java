package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "login")
@Entity
public class Login {

	@GeneratedValue
	private int userId;
	@Id
	@Email
	private String email;
	@NotEmpty(message = "Please enter your password")
	private String password;
	private boolean isLoggedIn = false;

}