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

	//READ
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable("id") int userId) throws UserNotFoundException{
		Users user = (userService.findById(userId));
		if (user == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@GetMapping("/user")
	public List<Users> viewAllUsers() {
		return userService.viewAllUsers();
	}

	//WRITE
	@PostMapping("/user")
	public Users addUsers(@RequestBody Users user) {
		return userService.register(user);
	}
	
	//UPDATE
	@PatchMapping("/user/{id}")
	public Users updateUsers(@PathVariable("id") int id, @RequestBody Users user) {
		if (userService.findById(id) == null) {
			throw new UserNotFoundException("User not found with given id:" + id);
		}
		return userService.updateUserDetails(user);
	}

	@PutMapping("/user/{id}")
	public Users updateUser(@PathVariable("id") int id, @RequestBody Users user) {
		return userService.updateUserDetails(user);
	}

	@PatchMapping("/user/{userId}")
	public void cancelSubscription(@PathVariable("userId") int userId) {
		userService.cancelSubscriptionById(userId);
	}

	//DELETE
	@DeleteMapping("/user/{id}")
	public Users deleteUserById(@PathVariable("id") int userId) {
		if (userService.findById(userId) == null) {
			throw new UserNotFoundException("User not found with given id:" + userId);
		}
		return userService.deleteUser(userId);
	}

}
