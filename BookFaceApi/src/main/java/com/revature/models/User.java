package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull
	@Column(unique=true, nullable=false, updatable=false)
	private String userUsername;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;
	
	@NotNull
	@Column(nullable=false)
	private String firstName;
	
	@NotNull
	@Column(nullable=false)
	private String lastName;
	
	@ManyToMany
	@JoinTable(
	        name = "friends", 
	        joinColumns = { @JoinColumn(name = "userId") }, 
	        inverseJoinColumns = { @JoinColumn(name = "friendId") }
	    )
    private Set<User> friendsList = new HashSet<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, @NotNull String user_username, @NotNull String user_password, @NotNull String first_name,
			@NotNull String last_name, Set<User> friendsList) {
		super();
		this.userId = user_id;
		this.userUsername = user_username;
		this.userPassword = user_password;
		this.firstName = first_name;
		this.lastName = last_name;
		this.friendsList = friendsList;
	}

	public Set<User> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(Set<User> friendsList) {
		this.friendsList = friendsList;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getUser_username() {
		return userUsername;
	}

	public void setUser_username(String user_username) {
		this.userUsername = user_username;
	}

	public String getUser_password() {
		return userPassword;
	}

	public void setUser_password(String user_password) {
		this.userPassword = user_password;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userUsername == null) ? 0 : userUsername.hashCode());
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
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (userId != other.userId)
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userUsername == null) {
			if (other.userUsername != null)
				return false;
		} else if (!userUsername.equals(other.userUsername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", user_username=" + userUsername + ", user_password=" + userPassword
				+ ", first_name=" + firstName + ", last_name=" + lastName + "]";
	}
	
	
	
	
}
