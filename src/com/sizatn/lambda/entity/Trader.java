package com.sizatn.lambda.entity;

/**
 * 
 * @desc 交易员
 * @author sizatn
 * @date Dec 17, 2017
 */
public class Trader {

	private String name;
	private String city;

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Trader() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Traders [name=" + name + ", city=" + city + "]";
	}

}
