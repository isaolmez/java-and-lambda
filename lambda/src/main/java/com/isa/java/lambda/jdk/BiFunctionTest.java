package com.isa.java.lambda.jdk;

import java.util.function.BiFunction;

public class BiFunctionTest {

    public static void main(String[] args) {
        biFunctionTest((t, u) -> (t + u), 20, 5);
    }

    public static <T, U, R> void biFunctionTest(BiFunction<T, U, R> biFunction, T param1,
            U param2) {
        R result = biFunction.apply(param1, param2);
        System.out.println(result);
    }
}
