package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;

@SpringBootTest
class UsersServiceTest {

	Logger logger = LogManager.getLogger(UsersServiceTest.class);

	@Autowired
	IUsersService userService;

	// Testing whether the User gets added to the database
	@Test
	@Disabled
	void testRegisterUsers() {
		Users u = new Users();

		u.setUserId(102);
		u.setPassword("abcdefgh1");
		u.setFirstname("Noel");
		u.setLastname("Sigh");
		u.setMobileNumber("9876543210");
		u.setEmail("abc@gmail.com");
		Date dateOfBirth = Date.valueOf("1999-08-15");
		u.setDateOfBirth(dateOfBirth);
		
		
		Users persistedUser = userService.createUser(u);
		logger.info(u);
		logger.info("Added Details Successfully");

		assertAll(

				() -> assertEquals(102, persistedUser.getUserId()),
				() -> assertEquals("abcdefgh1", persistedUser.getPassword()),
				() -> assertEquals("Noel", persistedUser.getFirstname()),
				() -> assertEquals("Sigh", persistedUser.getLastname()),
				() -> assertEquals("abc@gmail.com", persistedUser.getEmail()),
				() -> assertEquals("9876543210", persistedUser.getMobileNumber()),
				() -> assertEquals(dateOfBirth, persistedUser.getDateOfBirth()));
		
	}
				

	// Testing whether the user gets Updated or not in database
	@Test

	void testUpdateUserDetails() {
		Users user = new Users();

		user.setUserId(102);
		user.setPassword("abcdefgh1");
		user.setFirstname("Noel");
		user.setLastname("Singh");
		user.setMobileNumber("9876543210");
		user.setEmail("abc@gmail.com");

		Users user1 = userService.updateUser(user);

		logger.info(user1);
		logger.info("Updated details successfully:");

		assertEquals("Noel", user.getFirstname());
	}

	// Testing whether User database has Users or null
	@Test
	@Disabled
	void deleteUser() throws UserNotFoundException {
		Users user = userService.deleteUserByUserId(102);

		if (user == null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		System.out.println(user);

		logger.info(user);
		logger.info("Deleted user successfully:");

		assertEquals(102, user.getUserId());
	}

	// Testing whether the given id fetches the user or not
	@Test
	@Disabled
	void viewAllUsers() {
		List<Users> users = userService.getAllUsers();
		logger.info(users);
		logger.info("Fetched Details:");

		assertEquals(6, users.size());
	}

	// Testing whether the particular user removed from the database or not.
	@Test
	@Disabled
	public void viewUserById() {
		Users user = userService.findUserByUserId(10);
		logger.info(user);
		logger.info("Fetched Details by id:");

		if (user == null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}

		assertEquals("Noel", user.getFirstname());
	}

	/*
	 * @Test public void payThePenalty() { Users user =
	 * userService.findUserByUserId(40);
	 * 
	 * double penalty = userService.payThePenalty(user.getUserId(), 25);
	 * logger.info(user);
	 * 
	 * assertEquals(150.0, penalty); }
	 */

}
