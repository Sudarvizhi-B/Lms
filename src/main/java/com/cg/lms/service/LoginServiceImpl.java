package com.cg.lms.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Login;
import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.repository.ILoginRepository;
import com.cg.lms.repository.IUsersRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	ILoginRepository loginRepo;
	@Autowired
	IUsersRepository regRepo;

	@Override
	public Users login(Login user) {
		logger.info("User login");
		Optional<Users> u = Optional.ofNullable(regRepo.findUserByEmail(user.getEmail()));
		Users users = null;
		if (u.isPresent()) {
			Optional<Login> dbUsr = loginRepo.findById(user.getEmail());

			if (!dbUsr.isPresent() || !dbUsr.get().isLoggedIn()) {
				user.setLoggedIn(true);
				loginRepo.save(user);
				users = regRepo.findUserByEmail(user.getEmail());
				return users;
			}
		}

		return users;
	}

	@Override
	public String logout(String email) {
		logger.info("User logout");
		Optional<Login> userfield = loginRepo.findById(email);
		logger.info(userfield.get());
		Login dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getEmail().equals(email) && dbUsr.isLoggedIn()) {

			dbUsr.setLoggedIn(false);
			loginRepo.save(dbUsr);
			return "logged out";
		}
		throw new UserNotFoundException("User not logged in");
	}

	public Users getUser(String email) {
		Optional<Login> userfield = loginRepo.findById(email);
		logger.info(userfield.get());
		Login dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getEmail().equals(email) && dbUsr.isLoggedIn()) {
			Optional<Users> u = Optional.ofNullable(regRepo.findUserByEmail(email));
			Users user = u.get();
			Users obj = new Users();
			obj.setUserId(user.getUserId());
			obj.setAddress(user.getAddress());
			obj.setFirstname(user.getFirstname());
			obj.setEmail(user.getEmail());
			obj.setMobileNumber(user.getMobileNumber());

			return obj;
		}

		return null;

	}

}