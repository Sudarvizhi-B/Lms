package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Address;

public interface IAddressService {

	public Address addAddress(Address address);
	public Address updateAddressDetails(Address address);
	public List<Address> viewAddressList();
	public Address deleteAddressById(int id);
	public Address viewAddressByUserId(int userId);

}
