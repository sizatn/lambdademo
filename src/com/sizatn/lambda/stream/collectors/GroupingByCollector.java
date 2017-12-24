package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;
import com.sizatn.lambda.entity.Transaction;

/**
 * 
 * @desc 分组和多级分组，通过字段条件收集成map集合
 * @author sizatn
 * @date Dec 24, 2017
 */
public class GroupingByCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		// 按年份分组
		List<Transaction> transactions = new Transaction().transactions;
		Map<Integer, List<Transaction>> transactionsByYear = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
		transactionsByYear.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		List<Dish> menu = new Dish().menu;

		// 按菜的类型分组
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		dishesByType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});
		
		System.out.println("");

		// 多级分组，按菜的类型和卡路里等级分组
		Map<Dish.Type, Map<Dish.CaloriesLevel, List<Dish>>> dishesByTypeCaloriesLevel = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return Dish.CaloriesLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return Dish.CaloriesLevel.NORMAL;
					} else {
						return Dish.CaloriesLevel.FAT;
					}
				})));
		dishesByTypeCaloriesLevel.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});
	}

}
