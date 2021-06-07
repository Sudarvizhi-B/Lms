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

	void testRegisterUsers() {
		Users u = new Users();

		u.setUserId(102);
		Date dateOfBirth = Date.valueOf("1999-08-15");
		u.setDateOfBirth(dateOfBirth);
		Date subscriptionDate = Date.valueOf("2021-05-09");
		u.setSubscriptionDate(subscriptionDate);
		Date subExpireDate = Date.valueOf("2021-06-09");
		u.setSubExpireDate(subExpireDate);
		u.setSubscriptionStatus("Subscribed");

		Users persistedUser = userService.register(u);
		logger.info(u);
		logger.info("Added Details Successfully");

		assertAll(

				() -> assertEquals(102, persistedUser.getUserId()),
				() -> assertEquals(dateOfBirth, persistedUser.getDateOfBirth()),
				() -> assertEquals(subscriptionDate, persistedUser.getSubscriptionDate()),
				() -> assertEquals(subExpireDate, persistedUser.getSubExpireDate()),
				() -> assertEquals("Subscribed", persistedUser.getSubscriptionStatus()));
	}

	// Testing whether the user gets Updated or not in database
	@Test

	void testUpdateUserDetails() {
		Users user = new Users();

		user.setUserId(101);
		user.setSubscriptionStatus("Unsubscribed");
		Date dateOfBirth = Date.valueOf("1998-10-16");
		user.setDateOfBirth(dateOfBirth);
		Date subExpireDate = Date.valueOf("2021-09-09");
		user.setSubExpireDate(subExpireDate);
		Date subscriptionDate = Date.valueOf("2021-10-09");
		user.setSubscriptionDate(subscriptionDate);

		Users user1 = userService.updateUserDetails(user);

		logger.info(user1);
		logger.info("Updated details successfully:");

		assertEquals("Unsubscribed", user.getSubscriptionStatus());
	}

	// Testing whether User database has Users or null
	@Test

	void deleteUser() throws UserNotFoundException {
		Users user = userService.deleteUser(102);

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

	void viewAllUsers() {
		List<Users> users = userService.viewAllUsers();
		logger.info(users);
		logger.info("Fetched Details:");

		assertEquals(3, users.size());
	}

	// Testing whether the particular user removed from the database or not.
	@Test

	public void viewUserById() {
		Users user = userService.findById(10);
		logger.info(user);
		logger.info("Fetched Details by id:");

		if (user == null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}

		assertEquals("Unsubscribed", user.getSubscriptionStatus());
	}

	// Testing whether the status is Updated or not
	@Test

	public void cancelSubscription() {
		Users user = userService.findById(60);
		userService.cancelSubscriptionById(60);

		if (user == null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		logger.info("Updated user:");
		assertEquals("Cancelled", user.getSubscriptionStatus());
	}

	@Test
	public void payThePenalty() {
		Users user = userService.findById(40);

		double penalty = userService.payThePenalty(user.getUserId(), 25);
		logger.info(user);

		assertEquals(100.0, penalty);
	}

}
