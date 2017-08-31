package com.isa.java.lambda.streams.feature;

import com.isa.java.lambda.streams.common.RunThis;
import com.isa.java.lambda.streams.common.StaticMethodRunner;
import java.util.Random;
import java.util.stream.IntStream;

public class IntStreamOperations {

    private IntStreamOperations() {
    }

    public static void main(String[] args) {
        StaticMethodRunner.run(IntStreamOperations.class);
    }

    @RunThis("range()")
    public static void range() {
        IntStream.range(2, 10).forEachOrdered(System.out::print);
        System.out.println();
    }

    @RunThis("skip().limit()")
    public static void skipLimit() {
        IntStream.range(2, 10).skip(2).limit(2).forEachOrdered(System.out::print);
        System.out.println();
    }

    @RunThis("builder()")
    public static void builder() {
        IntStream.builder().add(1).add(3).add(5).build().forEachOrdered(System.out::print);
        System.out.println();
    }

    @RunThis("generate()")
    public static void generate() {
        IntStream.generate(new Random()::nextInt).limit(10)
                .forEachOrdered(System.out::print);
        System.out.println();
    }
}
