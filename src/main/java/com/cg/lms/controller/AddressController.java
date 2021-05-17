package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Address> viewAddressByUserId(int userId) {
		if (addService.viewAddressByUserId(userId) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + userId);
		}
		Address addressById =addService.viewAddressByUserId(userId);
		return new ResponseEntity<>(addressById, HttpStatus.OK);
	}

	@GetMapping("/address")
	public ResponseEntity<List<Address>> findAllAddresses() {
		List<Address> address = addService.viewAddressList();
		return new ResponseEntity<>(address,HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/address")
	public ResponseEntity<Address> save(@RequestBody Address address) {
		Address add = addService.addAddress(address);
		return new ResponseEntity<>(add,HttpStatus.OK);
	}

	// UPDATE
	@PutMapping("/address")
	public ResponseEntity<Address> update(@RequestBody Address address) {
		if (addService.updateAddressDetails(address) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + address);
		}
		Address update = addService.updateAddressDetails(address);
        return new ResponseEntity<>(update,HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteById(@PathVariable("id") int addressId) {
		if (addService.deleteAddressById(addressId) == null) {
			throw new AddressNotFoundException("Address not found with given id:" + addressId);
		}
		Address delete = addService.deleteAddressById(addressId);
		return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	
}
