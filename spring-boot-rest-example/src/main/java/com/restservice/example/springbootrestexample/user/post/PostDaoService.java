package com.restservice.example.springbootrestexample.user.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	
	private Integer postCount=4;
	
	private static List<Post> posts=new ArrayList<Post>();
	/*
	static {
		posts.add(new Post(1, 1, "Post1",new Date()));
		posts.add(new Post(2, 2, "Post2",new Date()));
		posts.add(new Post(3, 2, "Post3",new Date()));
		posts.add(new Post(4, 3, "Post4",new Date()));
	}
	
	//Retrieve all posts of a user
	public List<Post> retrieveAllPostsForUser(Integer userId)
	{
		
		List<Post> userPosts=new ArrayList<Post>();
		
		for(Post post:posts)
		{
			if(post.getUserId()==userId)
			{
				userPosts.add(post);
			}
		}
		return userPosts;
		
	}
	
	
	//Create a post for a user
	public Post createPost(Integer userId,Post post)
	{
		
		if(post.getId()==null)
		{
			post.setId(++postCount);
		}
		posts.add(post);
		return post;
		
	}
	
	//Retrieve details of a post
	public Post retrieveOnePostsForUser(Integer userId,Integer postId)
	{
		for(Post post:posts)
		{
			if(post.getUserId()==userId && post.getId()==postId)
			{
				return post;
			}
		}
		return null;
	}
	*/

}
