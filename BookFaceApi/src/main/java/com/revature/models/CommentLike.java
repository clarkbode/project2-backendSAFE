package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comment_likes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CommentLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;
	
	@NotNull
	private int commentId;
	
	@NotNull
	private Boolean likeValue;

	public CommentLike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentLike(int likeId, @NotNull int commentId, @NotNull Boolean likeValue) {
		super();
		this.likeId = likeId;
		this.commentId = commentId;
		this.likeValue = likeValue;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Boolean getLikeValue() {
		return likeValue;
	}

	public void setLikeValue(Boolean likeValue) {
		this.likeValue = likeValue;
	}
	
	
}
