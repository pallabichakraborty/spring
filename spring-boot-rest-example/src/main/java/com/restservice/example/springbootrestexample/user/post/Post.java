package com.restservice.example.springbootrestexample.user.post;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restservice.example.springbootrestexample.user.User;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	User user;
	
	String postDetails;
	Date postDateTime;
	
	public Post() {
		super();
	}

	public Post(Integer id, User user, String postDetails, Date postDateTime) {
		super();
		this.id = id;
		this.user = user;
		this.postDetails = postDetails;
		this.postDateTime = postDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public void setUserId(User user) {
		this.user = user;
	}

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}

	public Date getPostDateTime() {
		return postDateTime;
	}

	public void setPostDateTime(Date postDateTime) {
		this.postDateTime = postDateTime;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postDetails=" + postDetails + ", postDateTime=" + postDateTime + "]";
	}
	
	
	

}
