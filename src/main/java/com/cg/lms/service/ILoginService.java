package com.cg.lms.service;

import com.cg.lms.dto.LoginDto;
import com.cg.lms.entity.Login;
import com.cg.lms.entity.Users;

public interface ILoginService {
	/*
	 * Login User
	 */
	Users login(Login login);

	/*
	 * Logout User
	 */
	String logout(String userId);

	public Users getUser(String email);

}
