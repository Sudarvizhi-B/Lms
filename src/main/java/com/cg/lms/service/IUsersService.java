
package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Users;

public interface IUsersService {

	public Users findById(int id);
	public Users deleteUser(int id);
	public Users updateUserDetails(Users user);
	public Users register(Users user);
	public List<Users> viewAllUsers();
	public void cancelSubscriptionById(int userId);
	
}
