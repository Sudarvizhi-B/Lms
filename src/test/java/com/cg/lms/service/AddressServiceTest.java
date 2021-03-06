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

import com.cg.lms.entity.Address;
import com.cg.lms.entity.Users;

@SpringBootTest
class AddressServiceTest {

	Logger logger = LogManager.getLogger(UsersServiceTest.class);

	@Autowired
	IAddressService addService;

	// Testing whether address gets added into database or not
	@Test
	@Disabled
	void testShouldAddAddress() {
		Address userAdd = new Address();
		Users u = new Users();

		u.setUserId(102);
		u.setPassword("abcdefgh1");
		u.setFirstname("Noel");
		u.setLastname("Sigh");
		u.setMobileNumber("9876543210");
		u.setEmail("abc@gmail.com");
		Date dateOfBirth = Date.valueOf("1999-08-15");
		
		userAdd.setAddressId(2);
		userAdd.setAddress1("Nacharam");
		userAdd.setAddress2("SecBad");
		userAdd.setCity("Dilsuknagar");
		userAdd.setPincode(500001);
		userAdd.setState("Telangana");
		userAdd.setUsers(u);

		Address persistedUser = addService.addAddress(userAdd);
		logger.info("Added Successfully");

		assertAll(

				() -> assertEquals("Nacharam", persistedUser.getAddress1()),
				() -> assertEquals("SecBad", persistedUser.getAddress2()),
				() -> assertEquals("Dilsuknagar", persistedUser.getCity()),
				() -> assertEquals(500001, persistedUser.getPincode()),
				() -> assertEquals("Telangana", persistedUser.getState()));
	}

	// Testing whether address gets updated or not
	@Test
	@Disabled
	void testUpdateAddress() {
		Address addr = new Address();

		addr.setAddressId(123);
		addr.setAddress1("Nacharam");
		addr.setAddress2("SecBad");
		addr.setCity("Dilsuknagar");
		addr.setState("Telangana");
		addr.setPincode(500001);

		Address updateadd = addService.updateAddressDetails(addr);
		logger.info("Updated Successfully");
		assertEquals("Nacharam", addr.getAddress1());
	}

	// Testing whether address gets deleted from database or not
	@Test
	
	void testDeleteAddressById() {
		Address p = addService.deleteAddressById(2);
		logger.info(p);
		logger.info("Deleted successfully");

		assertEquals("Dilsukhnagar", p.getCity());
	}

	// Testing whether address is fetched by the given id
	@Test
	@Disabled
	void testShouldViewAddressByUserId() {
		Address add = addService.viewAddressByUserId(102);
		logger.info(add);
		logger.info("Fetched address successfully");

		assertEquals(500001, add.getPincode());
	}

	// Testing whether address list is present in database or not
	@Test
	@Disabled
	void testShouldViewAddressList() {
		List<Address> address = addService.viewAddressList();
		logger.info(address);
		logger.info("Fetched address successfully");

		assertEquals(4, address.size());
	}
}
