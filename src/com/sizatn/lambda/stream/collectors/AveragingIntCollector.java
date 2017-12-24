package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc 用averagingInt计算平均数，averagingLong和averagingDouble用法一样，用于求平均数字段为long或double的情况
 * @author sizatn
 * @date Dec 24, 2017
 */
public class AveragingIntCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println(avgCalories);
		
	}

}
