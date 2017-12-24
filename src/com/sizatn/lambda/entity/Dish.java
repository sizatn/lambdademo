package com.sizatn.lambda.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @desc
 * @author sizatn
 * @date Dec 17, 2017
 */
public class Dish {

	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;

	public static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public enum Type {
		MEAT, FISH, OTHER
	}
	
	public enum CaloriesLevel {
		DIET, NORMAL, FAT
	}

	public Dish() {
		super();
	}

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

}
