package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Address;
import com.cg.lms.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addRepo;
	
	//Used to add the address
    @Override
	public Address addAddress(Address address) {
		return addRepo.save(address);
	}
    
    //Used to update the address details
	@Override
	public Address updateAddressDetails(Address address) {
		Optional<Address> addr = addRepo.findById(address.getAddressId());
		if (!addr.isPresent()) {
			return null;
		}

		addr.get().setAddressId(address.getAddressId());
		addr.get().setAddress1(address.getAddress1());
		addr.get().setAddress2(address.getAddress2());
		addr.get().setCity(address.getCity());
		addr.get().setState(address.getState());
		addr.get().setPincode(address.getPincode());
		return addRepo.save(addr.get());
	}
    
	//Used to get all the address list from database
	@Override
	public List<Address> viewAddressList() {
		return addRepo.findAll();
	}
    
	//Used to delete the address based on id
	@Override
	public Address deleteAddressById(int userId) {
		Optional<Address> address = addRepo.findById(userId);
		if (!address.isPresent()) {
			return null;
		}
		addRepo.delete(address.get());
		return address.get();
	}
    
	//Used to view address by id
	@Override
	public Address viewAddressByUserId(int userId) {
		Optional<Address> address = Optional.of(addRepo.findAddressByUserId(userId));
		if (!address.isPresent()) {
			return null;
		}
		
		return address.get();
	}

}
