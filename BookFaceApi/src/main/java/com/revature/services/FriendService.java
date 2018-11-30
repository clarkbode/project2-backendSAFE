package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Friend;
import com.revature.repos.FriendRepo;

@Service
public class FriendService {
	
	@Autowired
	private FriendRepo friendRepo;
	
	public Friend save(Friend u) {
		return friendRepo.save(u);
	}

	public ArrayList<Friend> getByUserId(int id) {
		return friendRepo.getByUserId(id);
	}
	
}
