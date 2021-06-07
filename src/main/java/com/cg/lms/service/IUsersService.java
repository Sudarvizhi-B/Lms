
package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Users;

public interface IUsersService {
    //Method to be override by the implementing class
	public Users findById(int id);
	
	//Method to be override by the implementing class
	public Users deleteUser(int id);
	
	//Method to be override by the implementing class
    public Users updateUserDetails(Users user);
    
	//Method to be override by the implementing class
    public Users register(Users user);
    
	//Method to be override by the implementing class
    public List<Users> viewAllUsers();
    
	//Method to be override by the implementing class
    public void cancelSubscriptionById(int userId);
    
	//Method to be override by the implementing class
    public double payThePenalty(int userId, double amount);
	
}
