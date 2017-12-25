package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @desc 将数字按质数和非质数分区
 * @author sizatn
 * @date Dec 25, 2017
 */
public class Prime {

	public static void main(String[] args) {
		Map<Boolean, List<Integer>> primesList = partitionPrimes(20);
		primesList.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});
	}

	private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}

	private static boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate * i == 0);
	}

}
