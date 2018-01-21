package com.sizatn.lambda.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @desc 解析日期－时间对象
 * @author sizatn
 * @date Jan 21, 2018
 */
public class DateTimeFormatterTest {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2014, 3, 18);
		String s1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		String s2 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("");
		
		LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
		LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(date1);
		System.out.println(date2);
		
		System.out.println("");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d1 = LocalDate.now();
		String formattedDate = d1.format(formatter);
		System.out.println(formattedDate);
		LocalDate d2 = LocalDate.parse(formattedDate, formatter);
		System.out.println(d2);
	}

}
