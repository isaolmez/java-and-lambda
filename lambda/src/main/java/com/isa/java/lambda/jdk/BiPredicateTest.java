package com.isa.java.lambda.jdk;

import java.util.function.BiPredicate;

public class BiPredicateTest {

    public static void main(String[] args) {
        biPredicateTest((param1, param2) -> param1 == 1 && param2 == 1, 1, 2);
    }

    public static <T, U> void biPredicateTest(BiPredicate<T, U> biPredicate, T param1, U param2) {
        boolean result = biPredicate.test(param1, param2);
        System.out.println(result);
    }
}
