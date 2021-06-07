package com.cg.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping()
public class UsersController {

	Logger logger = LogManager.getLogger(UsersController.class);

	// @Autowired can be used to bean on the setter method
	@Autowired
	IUsersService userService;

	private static final String EXCEPTION = "User not found with given id:";

	/*
	 * This below function is used to get the user using userId and redirects to
	 * usersService
	 */

	@GetMapping("/user/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable("id") int userId) {
		Users user = (userService.findById(userId));
		if (user == null) {
			throw new UserNotFoundException(EXCEPTION + userId);
		}
		logger.info("Getting user by id:");
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	/*
	 * This below function is used to get all the users using and redirects to
	 * usersService
	 */
	@GetMapping("/user")
	public ResponseEntity<List<Users>> viewAllUsers() {
		List<Users> userList = userService.viewAllUsers();
		logger.info("Getting all users:");
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/users/penalty/{id}")
	public double payThePenalty(@PathVariable("id") int userId) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException(EXCEPTION + userId);
		}
		double amount = 25.0;
		logger.info("Paying penalty by id:");
		return userService.payThePenalty(userId, amount);
	}

	/*
	 * This below function is used to create a new user and redirects to the
	 * UsersService
	 */
	@PostMapping("/user")
	public ResponseEntity<Users> addUsers(@Valid @RequestBody Users user) {
		Users user1 = userService.register(user);
		logger.info(" Adding users:");
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	/*
	 * This below function is used to update the user using userId and redirects to
	 * usersService
	 */
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable("id") int userId, @RequestBody Users user) {
		Users users = userService.updateUserDetails(user);
		logger.info("Updating user by id:");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/*
	 * This below function is used to update the user and redirects to usersService
	 */
	@PutMapping("/user/{userId}")
	public void cancelSubscription(@PathVariable("userId") int userId) {
		userService.cancelSubscriptionById(userId);
		logger.info("updating subscriptionStatus:");

	}

	/*
	 * This below function is used to delete the user using userId and redirects to
	 * usersService
	 */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Users> deleteUserById(@PathVariable("id") int userId) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException(EXCEPTION + userId);
		}
		Users delete = userService.deleteUser(userId);
		logger.info("Deleting user by id:");
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
