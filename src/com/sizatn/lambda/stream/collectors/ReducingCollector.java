package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc reducing收集器
 * @author sizatn
 * @date Dec 24, 2017
 */
public class ReducingCollector {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		
		// 总热量
		int totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(totalCalories);
		
		System.out.println("");
		
		// 总热量
		int totalCalories1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		System.out.println(totalCalories1);
		
		System.out.println("");
		
		// 热量最高的菜
		Optional<Dish> mostCalories = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalories.get());
	}

}
