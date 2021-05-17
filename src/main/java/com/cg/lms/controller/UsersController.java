package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.service.IUsersService;

@RestController
public class UsersController {

	@Autowired
	IUsersService userService;

	// READ
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable("id") int userId) throws UserNotFoundException {
		Users user = (userService.findById(userId));
		if (user == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<Users>> viewAllUsers() {
		List<Users> userList = userService.viewAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/users/penalty/{id}")
	public double payThePenalty(@PathVariable("id") int userId) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		double amount = 25.0;
		return userService.payThePenalty(userId, amount);
	}

	// WRITE
	@PostMapping("/user")
	public ResponseEntity<Users> addUsers(@RequestBody Users user) {
		Users user1 = userService.register(user);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	// UPDATE
	@PatchMapping("/user/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable("id") int userId, @RequestBody Users user) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		Users update = userService.updateUserDetails(user);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable("id") int userId, @RequestBody Users user) {
		Users users = userService.updateUserDetails(user);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PatchMapping("/user/{userId}")
	public void cancelSubscription(@PathVariable("userId") int userId) {
		userService.cancelSubscriptionById(userId);
	}

	// DELETE
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Users> deleteUserById(@PathVariable("id") int userId) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		Users delete = userService.deleteUser(userId);
		return new ResponseEntity(delete, HttpStatus.OK);
	}

}
