package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Address;

public interface IAddressService {
    
	//Method to be override by the implementing class
    public Address addAddress(Address address);
    
	//Method to be override by the implementing class
    public Address updateAddressDetails(Address address);
	
    //Method to be override by the implementing class
    public List<Address> viewAddressList();
    
	//Method to be override by the implementing class
    public Address deleteAddressById(int id);
    
	//Method to be override by the implementing class
     public Address viewAddressByUserId(int userId);

}
