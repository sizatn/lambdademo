package com.sizatn.lambda.stream.mapandreduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @desc 对集合中每个元素应用函数
 * @author sizatn
 * @date Dec 19, 2016
 */
public class ForEachElement {

	public static void main(String[] args) {

		// Convert String to Uppercase and join them using coma
		List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		
		String g7Countries = g7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(g7Countries);

		// new way
		String g7Countrie = g7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(g7Countrie);
	}

}
