package com.fresco.healthcare.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fresco.healthcare.model.ApplicationUser;
import com.fresco.healthcare.repository.ApplicationUserRepository;


@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private ApplicationUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser user= userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with given username: "+username));
		
		return user;
	}
	
	public ApplicationUser getUserByUsername(String username) {
		ApplicationUser user=userRepository.findById(username).orElse(null);
		
		return user;
	}

}
