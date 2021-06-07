package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.lms.entity.Address;
import com.cg.lms.repository.IAddressRepository;

@ExtendWith(SpringExtension.class)
public class AddressMockitoTest {

	@InjectMocks
	AddressServiceImpl addService;

	@MockBean
	IAddressRepository addRepo;

	@BeforeEach()
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testRegisterAddress() {
		Address address = new Address(143, "BanjaraHills", "JubileeHilss", "Hyderabad", "Telangana", 500001);

		Mockito.when(addRepo.save(address)).thenReturn(address);

		Address persistedAdd = addService.addAddress(address);

		assertEquals(143, persistedAdd.getAddressId());
		assertEquals("BanjaraHills", persistedAdd.getAddress1());
		assertEquals("JubileeHilss", persistedAdd.getAddress2());
		assertEquals("Hyderabad", persistedAdd.getCity());
		assertEquals("Telangana", persistedAdd.getState());
		assertEquals(500001, persistedAdd.getPincode());
	}

	@Test
	void testUpdateAddress() {
		Address address = new Address(143, "JubileeHilss", "BanjaraHills", "Hyderabad", "Telangana", 500001);

		Mockito.when(addRepo.findById(143)).thenReturn(Optional.of(address));
		Mockito.when(addRepo.save(address)).thenReturn(address);

		Address persistedAdd = addService.updateAddressDetails(address);

		assertEquals(143, persistedAdd.getAddressId());
		assertEquals("JubileeHilss", persistedAdd.getAddress1());
		assertEquals("BanjaraHills", persistedAdd.getAddress2());
		assertEquals("Hyderabad", persistedAdd.getCity());
		assertEquals("Telangana", persistedAdd.getState());
		assertEquals(500001, persistedAdd.getPincode());
	}

	@Test
	void testShouldViewAddressList() {
		Address address1 = new Address(156, "JubileeHilss", "BanjaraHills", "Hyderabad", "Telangana", 500001);
		Address address2 = new Address(157, "Ramnagar", "HythNagar", "Hyderabad", "Telangana", 500001);
		Address address3 = new Address(158, "Shaikpet", "Tolichowki", "Hyderabad", "Telangana", 500001);

		List<Address> addressList = new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);
		addressList.add(address3);

		Mockito.when(addRepo.findAll()).thenReturn(addressList);

		List<Address> address = addService.viewAddressList();

		assertEquals(3, address.size());
	}

	@Test
	void testDeleteAddressById() {
		Address address = new Address(156, "JubileeHilss", "BanjaraHills", "Hyderabad", "Telangana", 500001);

		Mockito.when(addRepo.findById(156)).thenReturn(Optional.of(address));
		addRepo.deleteById(156);

		Address persistedAdd = addService.deleteAddressById(156);

		assertEquals(156, persistedAdd.getAddressId());
		assertEquals("JubileeHilss", persistedAdd.getAddress1());
		assertEquals("BanjaraHills", persistedAdd.getAddress2());
		assertEquals("Hyderabad", persistedAdd.getCity());
		assertEquals("Telangana", persistedAdd.getState());
		assertEquals(500001, persistedAdd.getPincode());
	}
}
