package com.isa.java.lambda.jdk;

import java.util.function.Consumer;

public class ConsumerTest {

    public static int i = 0;

    public static void main(String[] args) {
        consumerTest(t -> i += t, 5);

        System.out.println(i);

    }

    public static <T> void consumerTest(Consumer<T> consumer, T value) {
        consumer.accept(value);
    }
}
