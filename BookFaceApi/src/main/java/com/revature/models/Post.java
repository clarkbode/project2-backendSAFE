package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "posts")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
		
	@NotNull
	@Column(unique=true, nullable=false, updatable=false)
	private int authorId;
	
	@NotNull
	@Column(nullable=false)
	private String postBody;
	
	@NotNull
	@Column(nullable=false)
	private String postImage;
	
	@NotNull
	@Column(nullable=false)
	private int postLikes;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "post")
	private Set<Comment> comments;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "authorId", insertable=false, updatable=false)
	private User user;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + ((postBody == null) ? 0 : postBody.hashCode());
		result = prime * result + postId;
		result = prime * result + ((postImage == null) ? 0 : postImage.hashCode());
		result = prime * result + postLikes;
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
		Post other = (Post) obj;
		if (authorId != other.authorId)
			return false;
		if (postBody == null) {
			if (other.postBody != null)
				return false;
		} else if (!postBody.equals(other.postBody))
			return false;
		if (postId != other.postId)
			return false;
		if (postImage == null) {
			if (other.postImage != null)
				return false;
		} else if (!postImage.equals(other.postImage))
			return false;
		if (postLikes != other.postLikes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + postId + ", author_id=" + authorId + ", post_body=" + postBody + ", post_image="
				+ postImage + ", post_likes=" + postLikes + "]";
	}

	public int getPost_id() {
		return postId;
	}

	public void setPost_id(int post_id) {
		this.postId = post_id;
	}

	public int getAuthor_id() {
		return authorId;
	}

	public void setAuthor_id(int author_id) {
		this.authorId = author_id;
	}

	public String getPost_body() {
		return postBody;
	}

	public void setPost_body(String post_body) {
		this.postBody = post_body;
	}

	public String getPost_image() {
		return postImage;
	}

	public void setPost_image(String post_image) {
		this.postImage = post_image;
	}

	public int getPost_likes() {
		return postLikes;
	}

	public void setPost_likes(int post_likes) {
		this.postLikes = post_likes;
	}
	
	
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post(int post_id, @NotNull int author_id, @NotNull String post_body, @NotNull String post_image,
			@NotNull int post_likes, Set<Comment> comments, User user) {
		super();
		this.postId = post_id;
		this.authorId = author_id;
		this.postBody = post_body;
		this.postImage = post_image;
		this.postLikes = post_likes;
		this.comments = comments;
		this.user = user;
	}
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
