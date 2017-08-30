package com.isa.java.lambda.jdk;

import java.util.function.BiConsumer;

public class BiConsumerTest {

    public static void main(String[] args) {
        biConsumerTest((p1, p2) -> {
            System.out.println(p1 + p2);
        }, "hello", "world");
    }

    public static <T, U> void biConsumerTest(BiConsumer<T, U> biConsumer, T param1, U param2) {
        biConsumer.accept(param1, param2);
    }
}
