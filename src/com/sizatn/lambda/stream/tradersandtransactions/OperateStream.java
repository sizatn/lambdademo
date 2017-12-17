package com.sizatn.lambda.stream.tradersandtransactions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.sizatn.lambda.entity.Trader;
import com.sizatn.lambda.entity.Transaction;

/**
 * 
 * @desc 流处理
 * @author sizatn
 * @date Dec 17, 2017
 */
public class OperateStream {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 找出2011年的所有交易并按交易额排序（从低到高）
		List<Transaction> tr2011 = transactions.stream().filter(trans -> trans.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		tr2011.forEach(trans -> {
			System.out.println(trans.toString());
		});

		System.out.println("");

		// 交易员都在哪些不同的城市工作过
		List<String> cityList = transactions.stream().map(trans -> trans.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		cityList.forEach(System.out::println);

		Set<String> citySet = transactions.stream().map(trans -> trans.getTrader().getCity())
				.collect(Collectors.toSet());
		citySet.forEach(System.out::println);

		System.out.println("");

		// 查询处所有来自于剑桥的交易员，并按姓名排序
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge")).distinct()
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		traders.forEach(trader -> {
			System.out.println(trader.toString());
		});

		System.out.println("");

		// 返回所有交易员的姓名字符串，按字母顺序排序
		String traderStr1 = transactions.stream().map(trans -> trans.getTrader().getName()).distinct().sorted()
				.reduce("", (n1, n2) -> n1 + n2);
		System.out.println(traderStr1);

		String traderStr2 = transactions.stream().map(trans -> trans.getTrader().getName()).distinct().sorted()
				.collect(Collectors.joining(", "));
		System.out.println(traderStr2);

		System.out.println("");

		// 有没有交易员是在米兰工作的
		boolean milanBased = transactions.stream().anyMatch(trans -> trans.getTrader().getCity().equals("Milan"));
		System.out.println(milanBased);

		System.out.println("");

		// 打印生活在剑桥的交易员的所有交易额
		transactions.stream().filter(trans -> trans.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).sorted().forEach(System.out::println);

		System.out.println("");

		// 所有交易中，最高的交易额是多少
		Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(highestValue.get());

		System.out.println("");

		// 找到交易额最小的交易
		Optional<Transaction> smallestTransaction1 = transactions.stream()
				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(smallestTransaction1.get().toString());

		Optional<Transaction> smallestTransaction2 = transactions.stream()
				.min(Comparator.comparing(Transaction::getValue));
		System.out.println(smallestTransaction2.get().toString());

		System.out.println("");

	}
}
