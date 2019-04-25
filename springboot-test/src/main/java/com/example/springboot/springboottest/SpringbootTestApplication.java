package com.example.springboot.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootTestApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(SpringbootTestApplication.class, args);
		
		for(String name:applicationContext.getBeanDefinitionNames())
		{
			System.out.println(name);
		}
	}

}
