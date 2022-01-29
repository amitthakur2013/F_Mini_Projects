package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Models.Billing;
import com.example.project.Models.User;
import com.example.project.Repository.BillingRepository;
import com.example.project.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> finadAllUsers() {
		return this.userRepository.findAll();
	}

	public User finadAUser(int userid) {
		User user=this.userRepository.findById(userid).orElse(null);
		return user;
	}

	public User addNewUser(User user) {
		User resp=this.userRepository.save(user);
		return resp;
	}

	public void deleteUser(int id) {
		this.userRepository.deleteById(id);
		
	}

}
