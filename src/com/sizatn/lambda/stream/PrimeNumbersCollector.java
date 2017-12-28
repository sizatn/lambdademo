package com.sizatn.lambda.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 
 * @desc 自定义收集器
 * @author sizatn
 * @date Dec 27, 2017
 */
public class PrimeNumbersCollector
		implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

	/**
	 * @return
	 * @desc
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@SuppressWarnings("serial")
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<Boolean, List<Integer>>() {
			{
				put(true, new ArrayList<Integer>());
				put(false, new ArrayList<Integer>());
			}
		};
	}

	/**
	 * @return
	 * @desc 
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> m, Integer i) -> {
			m.get(isPrime(m.get(true), i)).add(i);
		};
	}

	/**
	 * @return
	 * @desc 
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> m1, Map<Boolean, List<Integer>> m2) -> {
			m1.get(true).addAll(m2.get(true));
			m1.get(false).addAll(m2.get(false));
			return m1;
		};
	}

	/**
	 * @return
	 * @desc 
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 * @desc 
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
	}

	private static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;
		for (A item : list) {
			if (!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}

}
