package com.sizatn.lambda.method;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @desc 排序
 * @author sizatn
 * @date Dec 17, 2017
 */
public class Sort {

	public static void main(String[] args) {

		List<String> str = Arrays.asList("a", "b", "A", "B");
		
		str.sort(String::compareToIgnoreCase);
		
		str.forEach(System.out::println);
	}

}
