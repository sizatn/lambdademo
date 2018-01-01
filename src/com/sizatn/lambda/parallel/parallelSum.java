package com.sizatn.lambda.parallel;

import java.util.stream.Stream;

/**
 * 
 * @desc 并行计算总和
 * @author sizatn
 * @date Dec 31, 2017
 */
public class parallelSum {
	
	public static void main(String[] args) {
		
		System.out.println(normalLongSum(1_000_000));
		System.out.println("");
		System.out.println(parallelLongSum(1_000_000));
	}
	
	public static long parallelLongSum(long n) {
		long start = System.currentTimeMillis();
		long sum = Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
		System.out.println("并行计算耗时（毫秒）：" + String.valueOf(System.currentTimeMillis() - start));
		return sum;
	}
	
	public static long normalLongSum(long n) {
		long start1 = System.currentTimeMillis();
		long sum1 = Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
		System.out.println("普通计算耗时（毫秒）：" + String.valueOf(System.currentTimeMillis() - start1));
		return sum1;
	}

}
