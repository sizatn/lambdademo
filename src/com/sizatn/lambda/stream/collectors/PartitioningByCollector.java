package com.sizatn.lambda.stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc partitioningBy
 *       分区函数，返回一个布朗类型，分组得到的map的键为boolean类型，最多可以分两组：true是一组和false是一组
 * @author sizatn
 * @date Dec 25, 2017
 */
public class PartitioningByCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		List<Dish> menu = new Dish().menu;

		// 按素食和非素食分组
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		partitionedMenu.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 取出素食
		List<Dish> vegetarianDishes = partitionedMenu.get(true);
		vegetarianDishes.forEach(System.out::println);

		System.out.println("");

		// 使用filter实现获取素食
		List<Dish> vegetarianDishes1 = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		vegetarianDishes1.forEach(System.out::println);

		System.out.println("");

		// 先按素食和非素食分组，再按菜的类型分组
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesType = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
		vegetarianDishesType.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 先按素食和非素食分组，再按热量最高的菜分组并返回该菜
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		mostCaloricPartitionedByVegetarian.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 先按素食和非素食分组，再按热量高于500的菜分组
		Map<Boolean, Map<Boolean, List<Dish>>> upCaloricPartitionedByVegetarian = menu.stream().collect(
				Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy(d -> d.getCalories() > 500)));
		upCaloricPartitionedByVegetarian.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

		System.out.println("");

		// 先按素食和非素食分组，再算出每类的菜的总数
		Map<Boolean, Long> vegetarianCount = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.counting()));
		vegetarianCount.forEach((key, value) -> {
			System.out.println(key.toString() + " = " + value.toString());
		});

	}

}
