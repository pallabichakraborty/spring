package com.restservice.example.springbootrestexample.user.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostService {
	@Autowired
	private PostDaoService service=new PostDaoService();
	
	//Retrieve all posts for a user - GET /users/{id}/posts
	@GetMapping("/users/{userId}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable Integer userId)
	{
		return service.retrieveAllPostsForUser(userId);
	}
	
	//Create a post for a user - POST /users/{userId}/posts
	@PostMapping("/users/{userId}/posts")
	public Post createPost(@PathVariable Integer userId,@RequestBody Post post)
	{
		return service.createPost(userId,post);
	}
	
	//Retrieve details of a post for a user - GET /users/{id}/posts/{postId}
		@GetMapping("/users/{userId}/posts/{postId}")
		public Post retrieveAllPostsForUser(@PathVariable Integer userId,@PathVariable Integer postId)
		{
			return service.retrieveOnePostsForUser(userId,postId);
		}

}
