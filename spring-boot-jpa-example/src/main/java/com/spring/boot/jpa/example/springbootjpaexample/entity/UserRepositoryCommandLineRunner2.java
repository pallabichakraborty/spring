package com.spring.boot.jpa.example.springbootjpaexample.entity;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner2 implements CommandLineRunner {
	
	private static final Logger log=LoggerFactory.getLogger(UserRepositoryCommandLineRunner2.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		System.out.println(user);
		userRepository.save(user);
		log.info("New user is created:"+user);
		
		Optional<User> userWithIdZero=userRepository.findById(0L);
		log.info("User with id 0:" + userWithIdZero);

		Optional<User> userWithIdOne=userRepository.findById(1L);
		log.info("User with id 1:" + userWithIdOne);
		

		List<User> users=userRepository.findAll();
		log.info("All Users:"+users);
	}
	

}
