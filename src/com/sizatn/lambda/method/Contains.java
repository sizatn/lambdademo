package com.sizatn.lambda.method;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * 
 * @desc 
 * @author sizatn
 * @date Dec 17, 2017
 */
public class Contains {

	public static void main(String[] args) {
		
		List<String> str = Arrays.asList("a", "b", "A", "B");

		BiPredicate<List<String>, String> contains = List::contains;
		
		System.out.println(contains.toString());
	}

}
