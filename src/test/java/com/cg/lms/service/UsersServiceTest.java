package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;

@SpringBootTest
class UsersServiceTest {

	@Autowired
	IUsersService userService;

	@Test
	@Disabled
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
		System.out.println(u);
		
		assertAll(

				() -> assertEquals(102, persistedUser.getUserId()),
				() -> assertEquals(dateOfBirth, persistedUser.getDateOfBirth()),
				() -> assertEquals(subscriptionDate, persistedUser.getSubscriptionDate()),
				() -> assertEquals(subExpireDate, persistedUser.getSubExpireDate()),
				() -> assertEquals("Subscribed", persistedUser.getSubscriptionStatus()));
	}

	@Test
	@Disabled
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
		System.out.println(user1);
		
		assertEquals("Unsubscribed", user1.getSubscriptionStatus());
	}

	@Test
	@Disabled
	void deleteUser() throws UserNotFoundException{
		Users user = userService.deleteUser(103);
		
		if(user==null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		System.out.println(user);
		
		assertEquals(103, user.getUserId());
	}

	@Test
	@Disabled
	void viewAllUsers() {
		List<Users> users = userService.viewAllUsers();
		System.out.println(users);
		
		assertEquals(2, users.size());
	}
	
	@Test
	@Disabled
	public void viewUserById() {
		Users user = userService.findById(102);
		System.out.println(user);
		
		if(user==null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		
		assertEquals("Subscribed", user.getSubscriptionStatus());
	}
	
	@Test
	public void cancelSubscription() {
		Users user = userService.findById(101);
		userService.cancelSubscriptionById(101);
		
		if(user==null) {
			throw new UserNotFoundException("User not found found with given user Id");
		}
		
		assertEquals("Cancelled",user.getSubscriptionStatus());
	}
	
	@Test
	public void payThePenalty() {
		Users user = userService.findById(40);
		
		double penalty = userService.payThePenalty(user.getUserId(), 25);
		System.out.println(user);
		
		assertEquals(375, penalty);
	}

}
