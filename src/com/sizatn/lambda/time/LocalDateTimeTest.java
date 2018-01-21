package com.sizatn.lambda.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * 
 * @desc LocalDateTime - 新的日期时间API
 * @author sizatn
 * @date Jan 7, 2018
 */
public class LocalDateTimeTest {

	public static void main(String[] args) {
		
		// 创建一个当前的LocalDateTime
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		// 创建一个LocalDateTime实例
		LocalDateTime dt1 = LocalDateTime.of(2018, Month.JANUARY, 7, 13, 48, 20);
		System.out.println(dt1);
		
		// 从LocalDateTime中提取LocalDate组件
		LocalDate date1 = dt1.toLocalDate();
		System.out.println(date1);
		
		// 从LocalDateTime中提取LocalTime组件
		LocalTime time1 = dt1.toLocalTime();
		System.out.println(time1);
		
		// 通过合并LocalDate和LocalTime来创建LocalDateTime实例
		LocalDate date = LocalDate.of(2018, 1, 7);
		LocalTime time = LocalTime.of(13, 48, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		System.out.println(dt2);
		
		// 通过对LocalDate的atTime方法创建LocalDateTime实例
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		System.out.println(dt3);
		
		LocalDateTime dt4 = date.atTime(time);
		System.out.println(dt4);
		
		// 通过对LocalTime的atDate方法创建LocalDateTime实例
		LocalDateTime dt5 = time.atDate(date);
		System.out.println(dt5);
	}
}
