package com.sizatn.lambda.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * 
 * @desc LocalDate - 新的日期API
 * @author sizatn
 * @date Jan 7, 2018
 */
public class LocalDateTest {

	public static void main(String[] args) {

		// 创建一个当前的日期
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// 创建一个指定的日期
		LocalDate localDate = LocalDate.of(2018, 1, 7);
		
		// 年份
		int year = localDate.getYear(); 
		System.out.println(year);
		
		// 月份
		Month month = localDate.getMonth();
		System.out.println(month);
		
		// 日期
		int day = localDate.getDayOfMonth();
		System.out.println(day);
		
		// 星期
		DayOfWeek week = localDate.getDayOfWeek();
		System.out.println(week);
		
		// 当前月份的天数
		int len = localDate.lengthOfMonth();
		System.out.println(len);
		
		// 是否是闰年
		boolean leap = localDate.isLeapYear();
		System.out.println(leap);
	}

}
