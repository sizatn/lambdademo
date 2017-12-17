package com.sizatn.lambda.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @desc 
 * @author sizatn
 * @date Dec 17, 2017
 */
public class StringSort {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a", "b", "A", "B");
		
		list.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
		list.forEach(System.out::println);
		
		System.out.println("");
		
		list.sort(String::compareToIgnoreCase);
		list.forEach(System.out::println);
		
	}

}
