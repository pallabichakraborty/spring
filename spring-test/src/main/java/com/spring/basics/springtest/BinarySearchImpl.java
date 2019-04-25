package com.spring.basics.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;


	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}



	//Sorting the Array
	//Serach the Array
	//Return the result 
	
	public int binarySearch(int[] number, int numberToSearchFor)
	{
		int[] sortedNumbers=sortAlgorithm.sort(number);
		System.out.println(sortAlgorithm);
		
		return 3;
	}
	
	

}
