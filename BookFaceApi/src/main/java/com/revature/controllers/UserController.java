package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.revature.models.Friend;

import com.revature.dto.Credential;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping
	public List<User> findAll() {
		return us.findAll();
	}
	
	@GetMapping("{id}")
	public User findById(@PathVariable int id) {
		return us.findById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User save(@RequestBody User u) {
		return us.save(u);
	}
	

	@PostMapping("/findByCred/user/{username}/pass/{password}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User findByCreds(@PathVariable String username, @PathVariable String password) {
		return us.findByCredentials(username, password);
	}
	
}