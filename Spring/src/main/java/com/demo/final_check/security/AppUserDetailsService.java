package com.demo.final_check.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.final_check.exception.UserAlreadyExistsException;
import com.demo.final_check.model.Role;
import com.demo.final_check.model.UserDb;
import com.demo.final_check.repository.RoleRepository;
import com.demo.final_check.repository.UserRepository;





@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	
	
	
	
	public AppUserDetailsService() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	AppUser appUser;
	UserDb user;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("username not found");
		else
			appUser=new AppUser(user);
		return appUser;
	}
	
	
	 public PasswordEncoder passwordEncoder() {
	       
	        return new BCryptPasswordEncoder();
	    }
	
	
	public void signup(UserDb user) throws UserAlreadyExistsException {
		
		UserDb userx  = userRepository.findByUsername(user.getUsername());
		if(userx!=null) {
			throw new UserAlreadyExistsException();
		}
		else {
		
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			Role role = roleRepository.findById(2);
			System.out.println(role);
			Set<Role> roleList = new HashSet<Role>();
			roleList.add(role);
			user.setRoleList(roleList);
			userRepository.save(user);
			
		
		}
		
		
	}
	
	
	
	

}
