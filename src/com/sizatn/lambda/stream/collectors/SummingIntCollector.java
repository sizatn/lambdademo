package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc 用summingInt计算总和，summingLong和summingDouble用法一样，用于求和字段为long或double的情况
 * @author sizatn
 * @date Dec 24, 2017
 */
public class SummingIntCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		
	}

}
