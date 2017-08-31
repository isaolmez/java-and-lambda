package com.isa.java.lambda.streams.feature;

import com.isa.java.lambda.streams.common.Person;
import com.isa.java.lambda.streams.common.PersonProvider;
import com.isa.java.lambda.streams.common.RunThis;
import com.isa.java.lambda.streams.common.StaticMethodRunner;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {
        StaticMethodRunner.run(StreamOperations.class);
    }

    @RunThis("map().reduce()")
    public static void mapAndReduce() {
        Integer mappedAndReduced = PersonProvider.personList().stream()
                .map(Person::getAge)
                .reduce(0, (age1, age2) -> age1 + age2);

        System.out.printf("Reduced sum: %s%n", mappedAndReduced);
    }

    @RunThis("map().reduce(): With BigDecimal")
    public static void mapAndReduceWithBigDecimal() {
        BigDecimal mappedAndReduced = PersonProvider.personList().stream()
                .map(Person::getAge)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("Reduced sum: %s%n", mappedAndReduced);
    }

    @RunThis("filter()")
    public static void filter() {
        PersonProvider.personList().stream()
                .filter(Person::isMarried)
                .findFirst().ifPresent(System.out::println);
    }

    @RunThis("max()")
    public static void max() {
        Optional<Person> max = PersonProvider.personList().stream()
                .max(Comparator.comparing(Person::getAge));

        max.ifPresent(person -> System.out.printf("Max: %s%n", person));
    }

    @RunThis("min()")
    public static void min() {
        Optional<Person> max = PersonProvider.personList().stream()
                .min(Comparator.comparing(Person::getAge));

        max.ifPresent(person -> System.out.printf("Min: %s%n", person));
    }

    @RunThis("allMatch()")
    public static void allMatch() {
        boolean allYoung = PersonProvider.personList().stream()
                .allMatch(person -> person.getAge() < 50);

        System.out.printf("All young: %s%n", allYoung);
    }

    @RunThis("noneMatch()")
    public static void noneMatch() {
        boolean noneYoung = PersonProvider.personList().stream()
                .noneMatch(person -> person.getAge() < 50);

        System.out.printf("All old: %s%n", noneYoung);
    }

    @RunThis("count()")
    public static void count() {
        long count = PersonProvider.personList().stream()
                .count();

        System.out.printf("Count: %s%n", count);
    }

    @RunThis("skip().limit()")
    public static void skipAndLimit() {
        List<Person> skippedAndLimited = PersonProvider.personList().stream()
                .sorted(Comparator.comparing(Person::getAge))
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());

        System.out.printf("Skipped and limited: %s%n", skippedAndLimited);
    }

    @RunThis("of()")
    public static void of() {
        int sum = Stream.of(1, 2, 3).mapToInt(Integer::intValue).sum();

        System.out.printf("Sum: %s%n", sum);
    }

    @RunThis("findFirst() and peek(): Lazy evaluation")
    public static void peek() {
        Optional<Integer> first = Stream.of(1, 2, 3)
                .filter(num -> num < 2)
                .peek(System.out::println)
                .findFirst();

        first.ifPresent(num -> System.out.printf("First: %s%n", num));
    }

    @RunThis("Stream closed")
    public static void reusing_stream() {
        Stream<String> stream = Stream.of("a", "b", "b", "d")
                .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);
        try {
            stream.noneMatch(s -> true);
        } catch (Exception e) {
            System.out.printf("Exception occurred: %s%n", e.getMessage());
        }
    }

    private StreamOperations() {
    }
}
