package com.cg.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.service.IUsersService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UsersController {
	/**
	 * Logger
	 */
	Logger logger = LogManager.getLogger(UsersController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IUsersService regservice;
	
	/**
	 * This below function is used to get a specific user using userid and redirects
	 * to the user service
	 */

	@GetMapping("/users/{userid}")
	public Users findUserByUserId(@PathVariable int userid) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		logger.info("Getting User by UserId:" + userid);
		return regservice.findUserByUserId(userid);

	}

	/**
	 * This below function is used to get all the user and redirects to the user
	 * service
	 */

	@GetMapping("/users")
	public List<Users> findAllusers() {
		logger.info("Printing all the Users");
		return regservice.getAllUsers();

	}

	/**
	 * This below function is used to create a new user and redirects to the user
	 * service
	 */
	@PostMapping("/users/add")
	public Users save(@Valid @RequestBody Users user) {
		logger.info("Creating a User");
		return regservice.createUser(user);
	}

	/**
	 * This below function is used to update a specific user based on the give
	 * userid and redirects to the user service
	 */

	@PutMapping("/users/update/{id}")
	public Users updateUser(@PathVariable("id") int userid, @Valid @RequestBody Users user) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this Userid");
		}
		logger.info("Updating the User" + userid);
		return regservice.updateUser(user);

	}

	/**
	 * This below function is used to delete a specific user based on the give
	 * userid and redirects to the user service
	 */

	@DeleteMapping("/users/{userid}")
	public Users deleteUserByUserId(@PathVariable int userid) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with Userid");
		}
		logger.info("Deleting the User by Userid" + userid);
		return regservice.deleteUserByUserId(userid);
	}

	/*@GetMapping("/users/penalty/{id}")
	public double payThePenalty(@PathVariable("id") int userId) {
		if (regservice.findUserByUserId(userId) == null) {
			throw new UserNotFoundException("User not found with UserId" + userId);
		}
		double amount = 25.0;
		logger.info("Paying penalty by id:");
		return regservice.payThePenalty(userId, amount);
	}

	@PatchMapping("/users/{userId}")
	public void cancelSubscription(@PathVariable("userId") int userId) {
		regservice.cancelSubscriptionById(userId);
		logger.info("updating subscriptionStatus:");

	}*/
}
