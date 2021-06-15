package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.lms.entity.Users;
import com.cg.lms.repository.IUsersRepository;

@ExtendWith(SpringExtension.class)
public class UsersMockitoTest {

	@InjectMocks
	UsersServiceImpl userService;

	@MockBean
	IUsersRepository userRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testRegisterUser() {
		Users user = new Users();

		user.setUserId(123);
		Date dateOfBirth = Date.valueOf("1998-02-01");
		user.setDateOfBirth(dateOfBirth);
		Date subscriptionDate = Date.valueOf("1999-02-01");
		

		Mockito.when(userRepo.save(user)).thenReturn(user);

		Users persistedUser = userService.createUser(user);

		assertEquals(123, persistedUser.getUserId());
		assertEquals(dateOfBirth, persistedUser.getDateOfBirth());
		
	}

	@Test
	void testUpdateUserDetails() {
		Users user = new Users();

		user.setUserId(40);
		
		Date dateOfBirth = Date.valueOf("1999-12-08");
		user.setDateOfBirth(dateOfBirth);
		

		Users user1 = userService.updateUser(user);

		Mockito.when(userRepo.findById(40)).thenReturn(Optional.of(user));
		Mockito.when(userRepo.save(user)).thenReturn(user);

		assertEquals("1999-12-08", user.getDateOfBirth());
	}

	@Test
	void deleteUser() {
		Users user = new Users();

		user.setUserId(40);
		
		Date dateOfBirth = Date.valueOf("1999-12-08");
		user.setDateOfBirth(dateOfBirth);
		Date subExpireDate = Date.valueOf("2019-10-01");
		

		Users persistedUser = userService.deleteUserByUserId(40);

		Mockito.when(userRepo.findById(40)).thenReturn(Optional.of(user));
		Mockito.when(userRepo.save(user)).thenReturn(user);

		userRepo.deleteById(40);

		assertEquals(40, user.getUserId());
	}

	@Test
	void viewAllUsers() {
		Users user1 = new Users();
		List<Users> userList = new ArrayList<>();

		user1.setUserId(40);
		
		Date dateOfBirth = Date.valueOf("1999-12-08");
		user1.setDateOfBirth(dateOfBirth);
		

		Users user2 = new Users();
		user2.setUserId(40);
		
		Date dateOfBirth1 = Date.valueOf("1999-12-08");
		user2.setDateOfBirth(dateOfBirth1);
		
		userList.add(user1);
		userList.add(user2);

		Mockito.when(userRepo.findAll()).thenReturn(userList);

		List<Users> users = userService.getAllUsers();
		assertEquals(2, users.size());
	}

}
