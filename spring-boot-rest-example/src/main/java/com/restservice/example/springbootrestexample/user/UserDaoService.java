package com.restservice.example.springbootrestexample.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private Integer usersCount=3;
	
	private static List<User> users=new ArrayList<User>();
	
	static {
		users.add(new User(1, "Someone1", new Date()));
		users.add(new User(2, "Someone2", new Date()));
		users.add(new User(3, "Someone3", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) 
	{
		if(user.getId()==null)
		{
			user.setId(++usersCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		
		return null;
		
	}
	
	public User deleteById(int id)
	{
		Iterator<User> usersData=users.iterator();
		
		while(usersData.hasNext())
		{
			User user=usersData.next();
			if(user.getId()==id)
			{
				usersData.remove();
				return user;
			}
		}
		
		return null;
	}

}
