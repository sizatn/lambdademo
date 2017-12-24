package com.sizatn.lambda.stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc maxBy:最大值，minBy:最小值
 * @author sizatn
 * @date Dec 24, 2017
 */
public class MaxByCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		
		// Max Calories
		Comparator<Dish> dishMaxCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> maxCaloriesDish = menu.stream().collect(Collectors.maxBy(dishMaxCaloriesComparator));
		
		System.out.println(maxCaloriesDish.get().toString());
		
		System.out.println("");
		
		// Min Calories
		Optional<Dish> minCaloriesDish = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
		
		System.out.println(minCaloriesDish.get().toString());
	}

}
