package com.sizatn.lambda.stream.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
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
 * @desc 自定义收集器，实现Collector接口，这里定义了一个质数（prime number）收集器
 * @desc Integer：流中元素的类型
 * @desc 第一个Map<Boolean, List<Integer>>：累加器类型
 * @desc 第二个Map<Boolean, List<Integer>>：collect操作的结果类型
 * @author sizatn
 * @date Dec 27, 2017
 */
public class PrimeNumbersCollector
		implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

	/**
	 * @return 返回一个在调用时创建累加器的函数
	 * @desc 创建用作累加器的Map，且初始化true和false两个键用来分别添加质数和非质数
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
	 * @desc 定义了如何收集流中元素的逻辑
	 * @desc 根据isPrime的结果，获取质数或非质数列表，将当前被测数添加到相应的列表中
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
	 * @desc 把两个部分累加器合并起来
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
	 * @desc 将累加器转换为collect操作的结果类型，此处不用转换，因此用identity函数收尾
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}

	/**
	 * @return
	 * @desc 这个收集器是IDENTITY_FINISH，但既不是UNORDERED也不是CONCURRENT，因为质数是按顺序发现的
	 * @author sizatn
	 * @date Dec 27, 2017
	 */
	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
	}

	public static boolean isPrime(List<Integer> primes, int candidate) {
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
