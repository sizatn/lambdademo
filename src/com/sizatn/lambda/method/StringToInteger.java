package com.sizatn.lambda.method;

import java.util.Arrays;
import java.util.List;

public class StringToInteger {
	
	public static void main(String[] args) {
		
		List<String> strs = Arrays.asList("10", "12", "5", "7", "0");
		
		strs.forEach(Integer::parseInt);
		
		strs.forEach(System.out::println);
		
	}

}
