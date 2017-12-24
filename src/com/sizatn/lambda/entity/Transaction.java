package com.sizatn.lambda.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @desc 交易
 * @author sizatn
 * @date Dec 17, 2017
 */
public class Transaction {

	private Trader trader;
	private int year;
	private int value;

	public Transaction() {
		super();
	}

	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public static List<Transaction> transactions = Arrays.asList(
			new Transaction(new Trader("Brian", "Cambridge"), 2011, 300),
			new Transaction(new Trader("Raoul", "Cambridge"), 2012, 1000),
			new Transaction(new Trader("Raoul", "Cambridge"), 2011, 400),
			new Transaction(new Trader("Mario", "Milan"), 2012, 710),
			new Transaction(new Trader("Mario", "Milan"), 2012, 700),
			new Transaction(new Trader("Alan", "Cambridge"), 2012, 950));

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}
