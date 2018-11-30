package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.revature.models.Friend;

import com.revature.dto.Credential;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(int id) {
		return userRepo.getOne(id);
	}

	public User save(User user) {
		return userRepo.save(user);
	}

	@Transactional
	public User findByCredentials(String username, String password) {
		Credential cred = new Credential(username, password); // fix this
		User u = userRepo.findByCredentials(username, password);

		if (cred.getUsername().equals(u.getUser_username()) && cred.getPassword().equals(u.getUser_password())) {
			return u;
		} else {

			return null;
		}

	}

}
