package com.example.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Models.User;
import com.example.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public ResponseEntity<?> getAllUSers() {
		return ResponseEntity.ok(userService.finadAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUSer(@PathVariable int id) {
		User user = userService.finadAUser(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		User res = userService.addNewUser(user);
		if (res != null) {
			return ResponseEntity.ok(user);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUSer(@PathVariable int id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("");
	}

}
