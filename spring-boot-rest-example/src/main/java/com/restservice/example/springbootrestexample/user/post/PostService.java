package com.restservice.example.springbootrestexample.user.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



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
	public ResponseEntity<Object> createPost(@PathVariable Integer userId,@RequestBody Post reqPost)
	{
		Post post=service.createPost(userId,reqPost);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	//Retrieve details of a post for a user - GET /users/{id}/posts/{postId}
		@GetMapping("/users/{userId}/posts/{postId}")
		public Post retrieveAllPostsForUser(@PathVariable Integer userId,@PathVariable Integer postId)
		{
			Post post=service.retrieveOnePostsForUser(userId,postId);
			if(post==null)
			{
				throw new PostNotFoundException("Post Id - " +postId+" User Id - "+userId);
			}
			return post;
		}

}
