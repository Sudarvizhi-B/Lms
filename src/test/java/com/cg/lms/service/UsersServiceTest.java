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
		Date subscriptionDate = Date.valueOf("2021-06-09");
		u.setSubscriptionDate(subscriptionDate);
		Date subExpireDate = Date.valueOf("2021-05-09");
		u.setSubExpireDate(subExpireDate);
		u.setSubscriptionStatus("Subscribed");

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
				() -> assertEquals(dateOfBirth, persistedUser.getDateOfBirth()),
				() -> assertEquals(subscriptionDate, persistedUser.getSubscriptionDate()),
				() -> assertEquals(subExpireDate, persistedUser.getSubExpireDate()),
				() -> assertEquals("Subscribed", persistedUser.getSubscriptionStatus()));
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
		user.setSubscriptionStatus("subscribed");
		Date dateOfBirth = Date.valueOf("1999-08-15");
		user.setDateOfBirth(dateOfBirth);
		Date subExpireDate = Date.valueOf("2021-06-09");
		user.setSubExpireDate(subExpireDate);
		Date subscriptionDate = Date.valueOf("2021-05-09");
		user.setSubscriptionDate(subscriptionDate);

		Users user1 = userService.updateUser(user);

		logger.info(user1);
		logger.info("Updated details successfully:");

		assertEquals("subscribed", user.getSubscriptionStatus());
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

		assertEquals("Unsubscribed", user.getSubscriptionStatus());
	}

	// Testing whether the status is Updated or not
	@Test
	@Disabled
	public void cancelSubscription() {
		Users user = userService.findUserByUserId(60);
		userService.cancelSubscriptionById(60);

		if (user == null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		logger.info("Updated user:");
		assertEquals("Cancelled", user.getSubscriptionStatus());
	}

	@Test
	public void payThePenalty() {
		Users user = userService.findUserByUserId(40);

		double penalty = userService.payThePenalty(user.getUserId(), 25);
		logger.info(user);

		assertEquals(150.0, penalty);
	}

}
