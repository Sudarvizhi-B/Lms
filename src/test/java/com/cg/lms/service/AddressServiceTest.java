package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Address;
import com.cg.lms.entity.Users;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	IAddressService addService;

	@Test
	//@Disabled
	void testShouldAddAddress() {
		Address userAdd = new Address();
		Users user = new Users();
		
		user.setUserId(101);
		Date dateOfBirth = Date.valueOf("1998-10-16");
		user.setDateOfBirth(dateOfBirth);
		Date subscriptionDate = Date.valueOf("2021-09-09");
		user.setSubscriptionDate(subscriptionDate);
		Date subExpireDate = Date.valueOf("2021-10-09");
		user.setSubExpireDate(subExpireDate);
		user.setSubscriptionStatus("Subscribed");

		userAdd.setAddressId(2);
		userAdd.setAddress1("Nacharam");
		userAdd.setAddress2("SecBad");
		userAdd.setCity("Dilsuknagar");
		userAdd.setPincode(500001);
		userAdd.setState("Telangana");
		userAdd.setUsers(user);
		
		Address persistedUser = addService.addAddress(userAdd);

		assertAll(

				() -> assertEquals("Nacharam", persistedUser.getAddress1()),
				() -> assertEquals("SecBad", persistedUser.getAddress2()),
				() -> assertEquals("Dilsuknagar", persistedUser.getCity()),
				() -> assertEquals(500001, persistedUser.getPincode()),
				() -> assertEquals("Telangana", persistedUser.getState()));
	}

	@Test
    //@Disabled
	void testUpdateAddress() {
		Address addr = new Address();
		
		addr.setAddressId(123);
		addr.setAddress1("Nacharam");
		addr.setAddress2("SecBad");
		addr.setCity("Dilsuknagar");
		addr.setState("Telangana");
		addr.setPincode(500001);
		
		Address updateadd = addService.updateAddressDetails(addr);
		assertEquals("Nacharam", addr.getAddress1());
	}

	@Test
	//@Disabled
	void testDeleteAddressById() {
		Address p = addService.deleteAddressById(2);
		System.out.println(p);
		
		assertEquals(2, p.getAddressId());
	}

	@Test
	@Disabled
	void testShouldViewAddressByUserId() {
		Address add = addService.viewAddressByUserId(102);
		System.out.println(add);
		
		assertEquals(501510, add.getPincode());
	}

	@Test
	//@Disabled
	void testShouldViewAddressList() {
		List<Address> address = addService.viewAddressList();
		System.out.println(address);
		
		assertEquals(0, address.size());
	}
}
