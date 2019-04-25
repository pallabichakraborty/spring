package com.spring.basics.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTestApplication {

	public static void main(String[] args) {
		
		//BinarySearchImpl binarysearch=new BinarySearchImpl(new BubbleSortAlgorithm());
		//Spring Application Context
		ApplicationContext applicationContext=SpringApplication.run(SpringTestApplication.class, args);
		BinarySearchImpl binarysearch=applicationContext.getBean(BinarySearchImpl.class);
		int result=binarysearch.binarySearch(new int[] {12,3,4,19}, 3);
		
		System.out.println(result);
		
		
	}

}
