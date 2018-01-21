package com.sizatn.lambda.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @desc 两个时间对象的duration
 * @author sizatn
 * @date Jan 21, 2018
 */
public class DurationTest {

	public static void main(String[] args) {

		LocalTime time1 = LocalTime.of(3, 20, 55);
		LocalTime time2 = LocalTime.now();

		LocalDateTime dateTime1 = LocalDateTime.of(2016, 3, 13, 14, 15, 20);
		LocalDateTime dateTime2 = LocalDateTime.now();

		Instant instant1 = Instant.ofEpochSecond(3);
		Instant instant2 = Instant.now();

		Duration duration1 = Duration.between(time1, time2);
		Duration duration2 = Duration.between(dateTime1, dateTime2);
		Duration duration3 = Duration.between(instant1, instant2);

		System.out.println(duration1.getSeconds());
		System.out.println(duration2.toDays());
		System.out.println(duration3.toHours());
		
		Duration threeMinutes1 = Duration.ofMinutes(3);
		Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
		
		System.out.println(threeMinutes1.toNanos());
		System.out.println(threeMinutes2.toMinutes());
	}

}
