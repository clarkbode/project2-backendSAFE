package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "post_Likes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PostLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;
	
	@NotNull
	private int postId;
	
	@NotNull
	private Boolean likeValue;

	
	
	public PostLike(int likeId, @NotNull int postId, @NotNull Boolean likeValue) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.likeValue = likeValue;
	}

	public PostLike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Boolean getLikeValue() {
		return likeValue;
	}

	public void setLikeValue(Boolean likeValue) {
		this.likeValue = likeValue;
	}
	
	

}
