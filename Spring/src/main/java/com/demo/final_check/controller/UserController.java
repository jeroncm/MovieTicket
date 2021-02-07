package com.demo.final_check.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.final_check.exception.UserAlreadyExistsException;
import com.demo.final_check.model.User;
import com.demo.final_check.model.UserDb;
import com.demo.final_check.security.AppUserDetailsService;




@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
//	@Autowired
//	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	public static List<UserDetails> userDetailList = new ArrayList<>();
	
	public UserController() {
		super();
		
	//userDetailList.add(org.springframework.security.core.userdetails.User.withUsername("user").password(passwordEncoder().encode("pwd")).roles("USER").build());
	//userDetailList.add(org.springframework.security.core.userdetails.User.withUsername("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").build());
	//userDetailList.add(org.springframework.security.core.userdetails.User.withUsername("anonymousUser").password(passwordEncoder().encode("pwd")).roles("ANON").build());

	
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		LOGGER.info("pwd encode");
//		return new BCryptPasswordEncoder();
//	}
	
	
	@PostMapping("")
	void signup(@RequestBody @Valid UserDb user) throws UserAlreadyExistsException {
//		LOGGER.info("in user Starts");
//		LOGGER.info(user.getFirstname());
//		Boolean details = inMemoryUserDetailsManager.userExists(user.getUsername());
//		if(!details) {
//			inMemoryUserDetailsManager.createUser(org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(passwordEncoder().encode(user.getPassword())).roles("USER").build());
//		
//	userDetailList.add(org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(passwordEncoder().encode(user.getPassword())).roles("USER").build());	
//		}
//		else {
//			throw new UserAlreadyExistsException();
//		}
//		LOGGER.info("userDetailList :"+userDetailList);
		
		
		
		
		appUserDetailsService.signup(user);

	}
	
	
	
}
