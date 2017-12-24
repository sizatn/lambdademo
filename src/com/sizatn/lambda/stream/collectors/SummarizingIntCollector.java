package com.sizatn.lambda.stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Dish;

/**
 * 
 * @desc 用summarizingInt计算总数、总和、最小值、平均数和最大值，summarizingLong和summarizingDouble用法一样，用于字段为long或double的情况
 * @author sizatn
 * @date Dec 24, 2017
 */
public class SummarizingIntCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		List<Dish> menu = new Dish().menu;
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
	}

}
