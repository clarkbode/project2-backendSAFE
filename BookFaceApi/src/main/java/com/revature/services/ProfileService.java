package com.revature.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	public Profile update(int id, Date birthday, @Nullable String image, String description, int authorId) {
		Profile updateProfile = profileRepo.getOne(id);
		updateProfile.setAuthorBirthdate(birthday);
		updateProfile.setProfileDescription(description);
		updateProfile.setProfileImage(image);
		return profileRepo.save(updateProfile);
	}
}
