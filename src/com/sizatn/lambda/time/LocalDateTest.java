package com.sizatn.lambda.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

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

		// 解析字符串成LocalDate
		LocalDate date = LocalDate.parse("2018-01-07");
		System.out.println(date);

		// 创建一个localDate的实例
		LocalDate localDate = LocalDate.of(2018, 1, 7);

		// 年份
		int year = localDate.getYear();
		System.out.println(year);

		int year1 = localDate.get(ChronoField.YEAR);
		System.out.println(year1);

		// 月份
		Month month = localDate.getMonth();
		System.out.println(month);

		int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(month1);

		// 日期
		int day = localDate.getDayOfMonth();
		System.out.println(day);

		int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
		System.out.println(day1);

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
