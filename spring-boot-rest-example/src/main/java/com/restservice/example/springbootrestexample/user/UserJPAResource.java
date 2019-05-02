package com.restservice.example.springbootrestexample.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restservice.example.springbootrestexample.user.post.Post;

@RestController
public class UserJPAResource {

	// Defining all the paths here
	private static final String USERS = "/jpa/users";
	private static final String USER_BY_ID = USERS + "/{id}";
	private static final String USER_POSTS=USER_BY_ID+"/posts";

	@Autowired
	private UserRepository repository;

	// retrieveAllUsers
	@RequestMapping(path = USERS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	// retrieveUser(int id)
	@RequestMapping(path = USER_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}

		// "all-users", server_path+"/users"
		// HATEOAS

		Resource<User> resource = new Resource<User>(user.get());

		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	// input - details of user
	// output -Created and return the created URI

	@RequestMapping(path = USERS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@RequestMapping(path = USER_BY_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@RequestMapping(path=USER_POSTS, method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Post> retrieveAllPostsForUser(@PathVariable Integer id)
	{
		 Optional<User> user=repository.findById(id);
		 
		 if(!user.isPresent())
		 {
			 throw new UserNotFoundException("id - " + id);
		 }
		 
		 return user.get().getPosts();
	}

}
