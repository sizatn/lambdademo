package com.sizatn.lambda.method;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @desc 
 * @author sizatn
 * @date Dec 17, 2017
 */
public class CompareTo {

	public static void main(String[] args) {

		List<Integer> ints = Arrays.asList(10, 12, 5, 7, 0);

		ints.sort(Integer::compareTo);

		ints.forEach(System.out::println);
	}

}
