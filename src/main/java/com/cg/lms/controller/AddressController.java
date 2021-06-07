package com.cg.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Address;
import com.cg.lms.exception.AddressNotFoundException;
import com.cg.lms.service.IAddressService;

@CrossOrigin
@RestController
@RequestMapping()
public class AddressController {

	Logger logger = LogManager.getLogger(UsersController.class);

	@Autowired
	IAddressService addService;

	private static final String EXCEPTION = "Address not found with given id:";

	/*
	 * This below function is used to get the address using userId and redirects to
	 * addService
	 */
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> viewAddressByUserId(int userId) {
		if (addService.viewAddressByUserId(userId) == null) {
			throw new AddressNotFoundException(EXCEPTION + userId);
		}
		Address addressById = addService.viewAddressByUserId(userId);
		logger.info("Fetched Details by Id");
		return new ResponseEntity<>(addressById, HttpStatus.OK);
	}

	/*
	 * This below function is used to get all the address and redirects to
	 * addService
	 */
	@GetMapping("/address")
	public ResponseEntity<List<Address>> findAllAddresses() {
		List<Address> address = addService.viewAddressList();
		logger.info("Fetched Details");
		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	/*
	 * This below function is used to add the address redirects to addService
	 */
	@PostMapping("/address")
	public ResponseEntity<Address> save(@Valid @RequestBody Address address) {
		Address add = addService.addAddress(address);
		logger.info("Added address successfully");
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	/*
	 * This below function is used to update the address and redirects to addService
	 */
	@PutMapping("/address")
	public ResponseEntity<Address> update(@RequestBody Address address) {
		if (addService.updateAddressDetails(address) == null) {
			throw new AddressNotFoundException(EXCEPTION + address);
		}
		Address update = addService.updateAddressDetails(address);
		logger.info("Updated address successfully");
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	/*
	 * This below function is used to delete the address and redirects to addService
	 */
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteById(@PathVariable("id") int addressId) {
		if (addService.deleteAddressById(addressId) == null) {
			throw new AddressNotFoundException(EXCEPTION + addressId);
		}
		Address delete = addService.deleteAddressById(addressId);
		logger.info("Deleted address successfully");
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
