package com.sizatn.lambda.time;

import java.time.LocalTime;

/**
 * 
 * @desc LocalTime - 新的时间API
 * @author sizatn
 * @date Jan 7, 2018
 */
public class LocalTimeTest {

	public static void main(String[] args) {
		
		// 解析字符串成LocalTime
		LocalTime time = LocalTime.parse("13:45:20");
		System.out.println(time);
		
		// 创建一个LocalTime实例
		LocalTime localTime = LocalTime.of(13, 45, 20);
		
		// 小时
		int hour = localTime.getHour();
		System.out.println(hour);
		
		// 分钟
		int minute = localTime.getMinute();
		System.out.println(minute);
		
		// 秒
		int second = localTime.getSecond();
		System.out.println(second);
	}
}
