package com.revature.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

@Embeddable
@DiscriminatorValue(value="true")
public class FriendId extends Friend implements Serializable{
	
	private int userId;
	private int friendId;
	
	public FriendId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendId(int user_id, int friend_id) {
		super();
		this.userId = user_id;
		this.friendId = friend_id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public int getFriend_id() {
		return friendId;
	}

	public void setFriend_id(int friend_id) {
		this.friendId = friend_id;
	}
	
}
