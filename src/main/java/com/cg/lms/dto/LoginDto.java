package com.cg.lms.dto;

import lombok.Data;

@Data
public class LoginDto {
	
	private int userId;
	//private String email;
	private String password;
	Boolean isLoggedIn;
	private String role;

}
