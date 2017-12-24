package com.sizatn.lambda.stream.collectors;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;
import com.sizatn.lambda.entity.Dish.CaloricLevel;
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
		Map<Integer, List<Transaction>> transactionsByYear = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getYear));
		transactionsByYear.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		List<Dish> menu = new Dish().menu;

		// 按菜的类型分组，同一类型的菜放到一个list集合中
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		dishesByType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 按菜的类型分组，计算每类菜的数量
		Map<Dish.Type, Long> typeCount = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		typeCount.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 按菜的类型分组，每一种类型中热量最高的菜
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(
				Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
		mostCaloricByType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		Map<Dish.Type, Dish> mostCaloricByType1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		mostCaloricByType1.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 按菜的类型分组，求出所有菜的热量的总和
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
		totalCaloriesByType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 按菜的类型分组，每种类型的菜单中都有哪些卡路里等级
		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					return convertCaloricLevel(dish);
				}, Collectors.toSet())));
		caloricLevelsByType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType1 = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					return convertCaloricLevel(dish);
				}, Collectors.toCollection(HashSet::new))));
		caloricLevelsByType1.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 多级分组，按菜的类型和卡路里等级分组
		Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloriesLevel = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
					return convertCaloricLevel(dish);
				})));
		dishesByTypeCaloriesLevel.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

	}

	/**
	 * 将卡路里值转换为卡路里等级
	 * 
	 * @param dish
	 * @return
	 */
	private static CaloricLevel convertCaloricLevel(Dish dish) {
		if (dish.getCalories() <= 400) {
			return Dish.CaloricLevel.DIET;
		} else if (dish.getCalories() <= 700) {
			return Dish.CaloricLevel.NORMAL;
		} else {
			return Dish.CaloricLevel.FAT;
		}
	}

}
