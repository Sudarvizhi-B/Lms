package com.cg.lms.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Users;
import com.cg.lms.repository.IUsersRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	IUsersRepository regRepo;

	/**
	 * creating a user in database
	 * 
	 */
	@Override
	public Users createUser(Users user) {
		Optional<Users> opt = Optional.ofNullable(regRepo.findUserByEmail(user.getEmail()));
		if(opt.isPresent()) {
			return null;
		}
		return regRepo.save(user);

	}

	@Override
	public Users findUserByUserId(int userId) {
		Optional<Users> optional = regRepo.findById(userId);
		if (!optional.isPresent()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<Users> getAllUsers() {
		return regRepo.findAll();
	}

	@Override
	public Users updateUser(Users user) {
		Users dbUser = getUser(user);
		if (isNullOrEmpty(dbUser.getFirstname())) {
			dbUser.setFirstname(user.getFirstname());
		}
		if (isNullOrEmpty(dbUser.getLastname())) {
			dbUser.setLastname(user.getLastname());
		}
		if (isNullOrEmpty(dbUser.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (isNullOrEmpty(dbUser.getPassword())) {
			dbUser.setPassword(user.getPassword());
		}
		if (isNullOrEmpty(dbUser.getMobileNumber())) {
			dbUser.setMobileNumber(user.getMobileNumber());
		}
		return regRepo.save(dbUser);
	}

	private boolean isNullOrEmpty(String value) {
		return value != null && !value.equals("");
	}

	private Users getUser(Users user) {
		Optional<Users> userfield = regRepo.findById(user.getUserId());
		Users dbUser = null;
		if (userfield.isPresent()) {
			dbUser = userfield.get();
		}
		return dbUser;
	}

	@Override
	public Users deleteUserByUserId(int userId) {
		Optional<Users> optional = regRepo.findById(userId);
		if (!optional.isPresent()) {
			return null;
		}
		regRepo.deleteById(userId);
		return optional.get();
	}

	// Used to update the status
	@Override
	public void cancelSubscriptionById(int userId) {
		regRepo.setSubscriptionStatus(userId);
	}

	@Override
	public double payThePenalty(int userId, double amount) {
		Users user = regRepo.findByUserId(userId);
		if (user == null) {
			return 0.0;
		}

		LocalDate date = LocalDate.now();
		LocalDate expireDate = user.getSubExpireDate().toLocalDate();

		Period period = Period.between(expireDate, date);
		int days = period.getDays();

		if (days >= 1) {
			double penalty = days * amount;
			return penalty;
		}
		return 0.0;
	}

}
