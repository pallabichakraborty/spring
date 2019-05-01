package com.restservice.example.springbootrestexample.user;

import java.net.URI;
import java.util.List;

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

@RestController
public class UserResource {
	
	//Defining all the paths here
	private static final String USERS = "/users";
	private static final String USER_BY_ID = USERS + "/{id}";
	
	@Autowired
	private UserDaoService service;
	
	//retrieveAllUsers
	@RequestMapping(path= USERS, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	//retrieveUser(int id)
	@RequestMapping(path= USER_BY_ID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<User> retrieveUser(@PathVariable int id)
	{
		User user=service.findOne(id);
		if(user==null)
		{
			throw new UserNotFoundException("id - "+id);
		}
		
		//"all-users", server_path+"/users"
		//HATEOAS

		Resource<User> resource=new Resource<User>(user);
		
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	//input - details of user
	//output -Created and return the created URI
	
	@RequestMapping(path= USERS, method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User user)
	{
		User savedUser=service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(path= USER_BY_ID, method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable int id)
	{
		User user=service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id -"+id);
		
	}
	

}
