package com.cg.lms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Users;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.repository.IUsersRepository;
import com.cg.lms.service.ILoginService;
import com.cg.lms.service.IUsersService;
import com.cg.lms.entity.Login;

@CrossOrigin(origins="http://localhost:3000")
@RestController()
@RequestMapping("/api")
public class LoginController {
	@Autowired
	IUsersService userService;
	@Autowired
	ILoginService loginService;
	@Autowired
	IUsersRepository regRepo;

	@PostMapping("/login")
	// login service
	public ResponseEntity<Users> Login(@Valid @RequestBody Login loginentity) {
		Users user = null;
		if (loginentity.getEmail() == null || loginentity.getPassword() == null || loginentity.getEmail().equals("")
				|| loginentity.getPassword().equals("")) {
			throw new UserNotFoundException("Userid or Password is invalid");
		}
		Users userfield = regRepo.findUserByEmail(loginentity.getEmail());
		if (userfield != null && userfield.getPassword().equals(loginentity.getPassword())) {
			user = loginService.login(loginentity);
		} else if (userfield != null) {
			throw new UserNotFoundException("Userid or Password is invalid");
		} else {
			throw new UserNotFoundException("User Not Registered");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// logout service
	@PostMapping("/logout/{email}")
	public String Logout(@Email @PathVariable("email") String email) {
		return loginService.logout(email);
	}

	// get user auth service
	@GetMapping("/user/getuser/{email}")
	public Users getUser(@Email @PathVariable("email") String email) {
		return loginService.getUser(email);
	}
}
