package com.restservice.example.springbootrestexample.user.post;

import java.util.Date;

public class Post {
	
	Integer id;
	Integer userId;
	String postDetails;
	Date postDateTime;
	
	public Post() {
		super();
	}

	public Post(Integer id, Integer userId, String postDetails, Date postDateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.postDetails = postDetails;
		this.postDateTime = postDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	
	

}
