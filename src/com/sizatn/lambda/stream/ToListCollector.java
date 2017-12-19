package com.sizatn.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ToListCollector {

	public static void main(String[] args) {

		Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
		
		List<Integer> numbers = stream.reduce(new ArrayList<Integer>(), (List<Integer> list1, Integer e) -> {
			list1.add(e);
			return list1;
		}, (List<Integer> list2, List<Integer> list3) -> {
			list2.addAll(list3);
			return list2;
		});
		
		numbers.forEach(System.out::println);
	}
}
