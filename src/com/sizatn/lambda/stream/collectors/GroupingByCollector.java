package com.sizatn.lambda.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Transaction;

/**
 * 
 * @desc 通过字段条件收集成map集合
 * @author sizatn
 * @date Dec 24, 2017
 */
public class GroupingByCollector {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		List<Transaction> transactions = new Transaction().transactions;

		Map<Integer, List<Transaction>> transactionsByYear = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));

		transactionsByYear.forEach((key, value) -> {
			System.out.println(key.toString() + " == " + value.toString());
		});

	}

}
