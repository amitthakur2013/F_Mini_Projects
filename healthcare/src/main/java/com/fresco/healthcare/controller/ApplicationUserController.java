package com.fresco.healthcare.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.healthcare.model.ApplicationUser;
import com.fresco.healthcare.repository.ApplicationUserRepository;
import com.fresco.healthcare.security.JwtUtil;
import com.fresco.healthcare.service.UserAuthService;

@RestController
public class ApplicationUserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	ApplicationUserRepository userRepo;

	@Autowired
	UserAuthService userDetailsService;

	@PostMapping("/signin")
	public ResponseEntity<Map<String, String>> authenticateUser(@RequestBody ApplicationUser signinRequest) {

		ApplicationUser userDet = userDetailsService.getUserByUsername(signinRequest.getUsername());

		if (userDet == null) {
			throw new UsernameNotFoundException("Username not found!");
		} else {
			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),
								signinRequest.getPassword()));

				// Username and Password both are valid

				SecurityContextHolder.getContext().setAuthentication(authentication);

				String jwt = jwtUtil.generateJwtToken(authentication);

				ApplicationUser userDetails = (ApplicationUser) authentication.getPrincipal();
				Map<String, String> respObj = new HashMap<>();

				respObj.put("message", "Authentication successful!");
				respObj.put("token", jwt);
				respObj.put("id", userDetails.getUsername());
				return ResponseEntity.ok(respObj);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Map<String, String> respObj = new HashMap<>();
				respObj.put("message", "Username or Password is Incorrect.");
				return new ResponseEntity(respObj, HttpStatus.UNAUTHORIZED);
			}
		}

	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody ApplicationUser signupRequest) {
		
		Map<String, String> respObj = new HashMap<>();
		ApplicationUser usercheck = userDetailsService.getUserByUsername(signupRequest.getUser_name());
		if (usercheck != null) {
			respObj.put("message", "Password or username policy failed");
			return ResponseEntity.badRequest().body(respObj);
		}

		ApplicationUser user = new ApplicationUser();
		user.setUser_name(signupRequest.getUser_name());
		user.setPassword(encoder.encode(signupRequest.getPassword()));
		user.setLocation(signupRequest.getLocation());
		user.setUser_email(signupRequest.getUser_email());
		user.setUser_mobile(signupRequest.getUser_mobile());

		userRepo.save(user);
		respObj.put("message", "Registration successful!");
		return ResponseEntity.ok(respObj);
	}
	
	@GetMapping("/viewprofile/{userId}")
	public ResponseEntity<?> getUserDetail(@PathVariable("userId") String username) {
		ApplicationUser user = userDetailsService.getUserByUsername(username);
		return ResponseEntity.ok(user);
	}
	

}
