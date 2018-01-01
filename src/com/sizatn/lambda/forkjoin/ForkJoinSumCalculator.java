package com.sizatn.lambda.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 
 * @desc 用分支/合并框架执行并行求和，继承RecursiveTask来创建可以用于分支/合并框架的任务
 * @author sizatn
 * @date Jan 1, 2018
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long serialVersionUID = -4199975267472038675L;

	/**
	 * @desc 要求和的数组
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	private final long[] numbers;

	/**
	 * @desc 子任务处理的数组的起始位置
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	private final int start;

	/**
	 * @desc 子任务处理的数组的终止位置
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	private final int end;

	/**
	 * @desc 最小数组大小
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	public static final long THRESHOLD = 10_000;

	/**
	 * @param numbers
	 * @desc 公共构造函数用于创建主任务
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	/**
	 * @param numbers
	 * @param start
	 * @param end
	 * @desc 私有构造函数用于以递归方式为主任务创建子任务
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		// 该任务负责求和的部分的大小
		int length = end - start;
		// 如果大小小于或等于阈值，顺序计算结果
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		// 创建一个子任务来为数组的前一半求和
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		// 利用另一个ForkJoinPool线程异步执行新创建的子任务
		leftTask.fork();
		// 创建一个任务为数组的后一半求和
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
		// 同步执行第二个子任务，有可能允许进一步递归划分
		Long rightResult = rightTask.compute();
		// 读取第一个子任务的结果，如果尚未完成就等待
		Long leftResult = leftTask.join();
		// 该任务的结果是两个子任务结果的组合
		return leftResult + rightResult;
	}

	/**
	 * @return
	 * @desc 在子任务不再可分时计算结果的简单算法
	 * @author sizatn
	 * @date Jan 1, 2018
	 */
	private Long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long[] numbers = LongStream.rangeClosed(1, 1000000).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		Long sum = new ForkJoinPool().invoke(task);
		System.out.println(sum);
	}

}
