package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc 用counting计算总和
 * @author sizatn
 * @date Dec 24, 2017
 */
public class CountingCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		List<Dish> menu = new Dish().menu;
		long howManyDishes = menu.stream().collect(Collectors.counting());
		System.out.println(howManyDishes);

		// new way
		long howManyDish = menu.stream().count();
		System.out.println(howManyDish);
	}

}
