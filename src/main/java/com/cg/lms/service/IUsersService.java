
package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Users;

public interface IUsersService {

	/**
	 * Retrieves user records with userid
	 * 
	 * @param i
	 * @return UserEntity
	 */
	public Users findUserByUserId(int i);

	/**
	 * Retrieves user
	 * 
	 * @return
	 */
	public List<Users> getAllUsers();

	/**
	 * Creates user record in the entity table
	 * 
	 * @param UserEntity
	 * @return UserEntity
	 */
	public Users createUser(Users user);

	public Users updateUser(Users user);

	public Users deleteUserByUserId(int userid);

}
