package com.fresco.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fresco.healthcare.model.ApplicationUser;
import com.fresco.healthcare.repository.ApplicationUserRepository;

import org.json.simple.JSONObject;




@Service
public class ApplicationUserService {
	
	@Autowired
	private ApplicationUserRepository userRepository;
	
	
	public ApplicationUser getUserByUsername(String username) {
		ApplicationUser user=userRepository.findById(username).orElse(null);
		
		return user;
	}
	
	public ApplicationUser editUser(String username, ApplicationUser user) {
		return null;
	}

}


