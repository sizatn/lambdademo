package com.sizatn.lambda.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @desc 以年、月或日的方式对多个时间单位建模
 * @author sizatn
 * @date Jan 21, 2018
 */
public class PeriodTest {
	
	public static void main(String[] args) {
		
		Period tenDays1 = Period.ofDays(10);
		Period tenDays2 = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		
		System.out.println(tenDays1.getDays());
		System.out.println(tenDays2.getDays());
		System.out.println(threeWeeks.get(ChronoUnit.DAYS));
		System.out.println(twoYearsSixMonthsOneDay.getYears());
	}

}
