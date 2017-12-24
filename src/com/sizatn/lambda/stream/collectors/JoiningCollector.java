package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc 用joining对流中的每一个对象应用toString方法得到的所有字符串连接成一个字符串
 * @author sizatn
 * @date Dec 24, 2017
 */
public class JoiningCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		String shirtName = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shirtName);
		
	}

}
