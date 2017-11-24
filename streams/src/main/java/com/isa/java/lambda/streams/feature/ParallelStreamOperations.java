package com.isa.java.lambda.streams.feature;

import com.isa.java.lambda.streams.common.RunThis;
import com.isa.java.lambda.streams.common.StaticMethodRunner;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class ParallelStreamOperations {

    private ParallelStreamOperations() {
    }

    public static void main(String[] args) {
        StaticMethodRunner.run(ParallelStreamOperations.class);
    }

    @RunThis("parallel()")
    public static void parallel() {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel()
                .mapToInt(Integer::intValue)
                .peek(num -> System.out
                        .printf("Peek: %s in %s%n", num, Thread.currentThread().getName()))
                .sum();

        System.out.printf("Sum: %s%n", sum);
    }

    @RunThis("parallel().sorted()")
    public static void parallelSort() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel()
                .sorted(Collections.reverseOrder(Comparator.comparing(Integer::intValue)))
                .forEachOrdered(num -> System.out
                        .printf("Number: %s in %s%n", num, Thread.currentThread().getName()));
    }
}
