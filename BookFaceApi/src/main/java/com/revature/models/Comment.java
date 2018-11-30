package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity
//@Table(schema = "project_2", name = "comments")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "comments", schema = "project_2") // CLARK: ADDING NEW COMMENTS CAUSES AN ERROR! ERROR: column comment0_.author_id does not exist
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@NotNull
	@Column(nullable=false)
	private String commentBody;
	
	@NotNull
	@Column(nullable=false)
	private int commentLikes;
	
	@NotNull
	@Column(nullable=false)
	private int authorId;
	
	@NotNull
	@Column(nullable=false)
	private int postId;
	

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, @NotNull String commentBody, @NotNull int commentLikes, @NotNull int authorId,
			@NotNull int postId) {
		super();
		this.commentId = commentId;
		this.commentBody = commentBody;
		this.commentLikes = commentLikes;
		this.authorId = authorId;
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public int getCommentLikes() {
		return commentLikes;
	}

	public void setCommentLikes(int commentLikes) {
		this.commentLikes = commentLikes;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + ((commentBody == null) ? 0 : commentBody.hashCode());
		result = prime * result + commentId;
		result = prime * result + commentLikes;
		result = prime * result + postId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (authorId != other.authorId)
			return false;
		if (commentBody == null) {
			if (other.commentBody != null)
				return false;
		} else if (!commentBody.equals(other.commentBody))
			return false;
		if (commentId != other.commentId)
			return false;
		if (commentLikes != other.commentLikes)
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}
	
	
	

}
