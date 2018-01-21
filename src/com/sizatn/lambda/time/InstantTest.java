package com.sizatn.lambda.time;

import java.time.Instant;

/**
 * 
 * @desc 时间建模，以传统的设定为UTC时区1970年1月1日午夜时分开始计算
 * @author sizatn
 * @date Jan 21, 2018
 */
public class InstantTest {

	public static void main(String[] args) {
		
		Instant i = Instant.now();
		System.out.println(i);

		Instant instant1 = Instant.ofEpochSecond(3);
		System.out.println(instant1);
		
		Instant instant2 = Instant.ofEpochSecond(3, 0);
		System.out.println(instant2);
		
		Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
		System.out.println(instant3);
		
		Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
		System.out.println(instant4);
	}

}
