package com.sizatn.lambda.stream.prime;

import java.util.ArrayList;
import java.util.HashMap;
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
		Map<Boolean, List<Integer>> primesList1 = partitionPrimes(20);
		primesList1.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		Map<Boolean, List<Integer>> primesList2 = partitionPrimesWithCustomCollector(20);
		primesList2.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		Map<Boolean, List<Integer>> primesList3 = partitionPrimesWithCustomCollector1(20);
		primesList3.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});
	}

	/**
	 * @param n
	 * @return
	 * @desc partitioningBy实现质数
	 * @author sizatn
	 * @date Dec 31, 2017
	 */
	private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}

	private static boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate * i == 0);
	}

	/**
	 * @param n
	 * @return
	 * @desc 自定义收集器实现质数
	 * @author sizatn
	 * @date Dec 31, 2017
	 */
	private static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
	}

	/**
	 * @param n
	 * @return
	 * @desc 自定义收集器实现质数（匿名内部类），可读性和可复用性较差
	 * @author sizatn
	 * @date Dec 31, 2017
	 */
	@SuppressWarnings("serial")
	private static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector1(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(() -> new HashMap<Boolean, List<Integer>>() {
			{
				put(true, new ArrayList<>());
				put(false, new ArrayList<>());
			}
		}, (m, i) -> {
			m.get(PrimeNumbersCollector.isPrime(m.get(true), i)).add(i);
		}, (m1, m2) -> {
			m1.get(true).addAll(m2.get(true));
			m1.get(false).addAll(m2.get(false));
		});
	}
}
