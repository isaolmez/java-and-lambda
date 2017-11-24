package com.isa.java.lambda.jdk;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        predicateTest((param1) -> param1 == 99, 99);
    }

    public static <T> void predicateTest(Predicate<T> predicate, T param1) {
        System.out.println(predicate.test(param1));
    }
}
