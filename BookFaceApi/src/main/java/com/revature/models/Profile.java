package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="profiles")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Profile {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int profileId;
	
	@Column(name="author_birthdate",updatable=true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date authorBirthdate;
	
	@Column(name="profile_image")
	private String profileImage;
	
	@Column(name="profile_description")
	private String profileDescription;

	@Column(name="author_id")
	private int authorId;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(int profileId, Date authorBirthdate, String profileImage, String profileDescription,
			int authorId) {
		super();
		this.profileId = profileId;
		this.authorBirthdate = authorBirthdate;
		this.profileImage = profileImage;
		this.profileDescription = profileDescription;
		this.authorId = authorId;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Date getAuthorBirthdate() {
		return authorBirthdate;
	}

	public void setAuthorBirthdate(Date authorBirthdate) {
		this.authorBirthdate = authorBirthdate;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
}

