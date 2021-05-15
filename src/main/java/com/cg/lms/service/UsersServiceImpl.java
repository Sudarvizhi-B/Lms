package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Users;
import com.cg.lms.repository.IUsersRepository;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	IUsersRepository userRepo;

	@Override
	public Users deleteUser(int id) {
		Optional<Users> user = userRepo.findById(id);
		if (!user.isPresent()) {
			return null;
		}
		
		userRepo.deleteById(id);
		return user.get();
	}

	@Override
	public Users updateUserDetails(Users user) {
		Optional<Users> user1 = userRepo.findById(user.getUserId());
		if (!user1.isPresent()) {
			return null;
		}
		
		Users users = user1.get();
		users.setSubscriptionDate(user.getSubscriptionDate());
		users.setSubscriptionStatus(user.getSubscriptionStatus());
		users.setDateOfBirth(user.getDateOfBirth());
		users.setSubExpireDate(user.getSubExpireDate());
		
		return userRepo.save(users);
	}

	@Override
	public Users register(Users user) {
		return userRepo.save(user);
	}

	@Override
	public List<Users> viewAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users findById(int userId) {
		Optional<Users> user = userRepo.findById(userId);
		if (!user.isPresent()) {
			return null;
		}
		
		return user.get();
	}

	@Override
	public void cancelSubscriptionById(int userId) {
		userRepo.setSubscriptionStatus(userId);
	}

}
