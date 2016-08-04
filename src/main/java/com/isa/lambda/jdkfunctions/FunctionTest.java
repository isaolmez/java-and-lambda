package com.isa.lambda.jdkfunctions;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		functionTest((t) -> t + 5, 5);
	}

	public static <T, R> void functionTest(Function<T, R> function, T param) {
		R result = function.apply(param);
		System.out.println(result);
	}
}
