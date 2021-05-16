package com.cg.lms.service;

//import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
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

	@Override
	public double payThePenalty(int userId, double amount) {
		Users user = userRepo.findById(userId).get();
		if (user == null) {
			return 0.0;
		}
		
		LocalDate date = LocalDate.now();
		LocalDate expireDate = user.getSubExpireDate().toLocalDate();
		
		Period period = Period.between(expireDate, date);
		int days = period.getDays();
		
		if(days>=1) {
			double penalty = days*amount;
			return penalty;
		}
		return 0.0;
	}
	
}
