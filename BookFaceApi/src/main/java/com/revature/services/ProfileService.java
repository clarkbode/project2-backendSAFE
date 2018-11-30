package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Profile;
import com.revature.repos.ProfileRepo;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepo profileRepo;
	
	public Profile findById(int id) {
		return profileRepo.getOne(id);
	}

	public Profile save(Profile p) {
		return profileRepo.save(p);
	}
	
}
