package com.sizatn.lambda.time;

import java.time.Instant;

public class InstantTest {

	public static void main(String[] args) {

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
