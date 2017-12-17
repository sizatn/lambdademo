package com.sizatn.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 
 * @desc 数值流，range方法是不包含结束值，rangeClosed方法则包含结束值
 * @author sizatn
 * @date Dec 17, 2017
 */
public class IntegerStream {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(20, 30, 40, 90, 100, 1000, 999,890);
		
		// 求和
		int sum = intList.stream().reduce(0, Integer::sum);
		System.out.println(sum);
		
		System.out.println("");
		
		// 获得1到100内所有偶数
		IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).forEach(System.out::println);
	}
}
