package com.isa.lambda.syntax;

import java.util.function.Predicate;

public class Syntax {
	private interface MultiParams {
		int process(int... num);
	}

	public static void main(String[] args) {
		/**
		 * With a parameter type. Automatic return
		 * There must be a single expression
		 */
		test((String p) -> true, "Hello");

		/**
		 * Without a parameter type. Automatic return
		 */
		test(p -> true, "Hello");

		/**
		 * With braces. Manual return.
		 */
		test(p -> {
			System.out.println("Inside braces, single expression is determined by the braces");
			return true;
		}, "Hello");

		/**
		 * With multiple parameters.
		 */
		testMulti((int... nums) -> {
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}

			return sum;
		}, 1, 2, 3);

		/**
		 * Can assign to references.
		 * This references to a class that implements the Predicate interface.
		 */
		Predicate<String> predicate = p -> true;
		System.out.println(predicate.test("Hi"));

	}

	public static <T> void test(Predicate<T> predicate, T t) {
		if (predicate.test(t)) {
			System.out.println(t);
		}
	}

	public static <T> void testMulti(MultiParams twoParams, int... numbers) {
		System.out.println(twoParams.process(numbers));
	}
}
