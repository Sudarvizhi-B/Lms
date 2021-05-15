package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Address;
import com.cg.lms.exception.AddressNotFoundException;
import com.cg.lms.service.IAddressService;

@RestController
public class AddressController {

	@Autowired
	IAddressService addService;

	// READ
	@GetMapping("/address/{id}")
	public Address viewAddressByUserId(int userId) {
		if (addService.viewAddressByUserId(userId) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + userId);
		}
		return addService.viewAddressByUserId(userId);
	}

	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		return addService.viewAddressList();
	}

	// WRITE
	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		return addService.addAddress(address);
	}

	// UPDATE
	@PutMapping("/address")
	public Address update(@RequestBody Address address) {
		if (addService.updateAddressDetails(address) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + address);
		}

		return addService.updateAddressDetails(address);
	}

	// DELETE
	@DeleteMapping("/address/{id}")
	public Address deleteById(@PathVariable("id") int addressId) {
		if (addService.deleteAddressById(addressId) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + addressId);
		}
		return addService.deleteAddressById(addressId);
	}
	
}
