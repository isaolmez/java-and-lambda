package com.isa.java.lambda.streams.feature;

import com.isa.java.lambda.streams.common.Person;
import com.isa.java.lambda.streams.common.PersonProvider;
import com.isa.java.lambda.streams.common.RunThis;
import com.isa.java.lambda.streams.common.StaticMethodRunner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorOperations {

    public static void main(String[] args) {
        StaticMethodRunner.run(CollectorOperations.class);
    }

    @RunThis("Collectors.toList(): Return as List")
    public static void collector() {
        List<Person> filtered = PersonProvider.personList().stream()
                .filter(Person::isMarried)
                .collect(Collectors.toList());

        System.out.printf("Filtered: %s%n", filtered);
    }

    @RunThis("Collectors.toMap(): Return as Map")
    public static void toMap() {
        Map<String, Person> nameToPerson = PersonProvider.personList().stream()
                .collect(Collectors.toMap(Person::getName, Function.identity()));

        System.out.printf("Name to person: %s%n", nameToPerson);
    }

    @RunThis("Collectors.toSet(): Collect as Set")
    public static void toSet() {
        Set<Integer> ages = PersonProvider.personList().stream()
                .map(Person::getAge)
                .collect(Collectors.toSet());

        System.out.printf("Ages: %s%n", ages);
    }

    @RunThis("Collectors.groupingBy(): Group by property and return map")
    public static void groupingBy() {
        Map<Integer, List<Person>> personByAge = PersonProvider.personList().stream()
                .collect(Collectors.groupingBy(Person::getAge));

        personByAge.forEach((age, list) -> System.out.format("Age %d: %s%n", age, list));
    }

    @RunThis("Collectors.averagingDouble(): Take average of double values")
    public static void averagingDouble() {
        Double average = PersonProvider.personList().stream()
                .collect(Collectors.averagingDouble(Person::getAge));

        System.out.printf("Average: %s%n", average);
    }

    @RunThis("Collectors.averagingInt(): Take average of int values")
    public static void averagingInt() {
        Double average = PersonProvider.personList().stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.printf("Average: %s%n", average);
    }

    @RunThis("Collectors.counting(): Count the values in the stream")
    public static void counting() {
        Long count = PersonProvider.personList().stream()
                .collect(Collectors.counting());

        System.out.printf("Count: %s%n", count);
    }

    @RunThis("Collectors.collectingAndThen(): Collect and then apply function")
    public static void collectingAndThen() {
        List<Person> subList = PersonProvider.personList().stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), list -> list.subList(0, 2)));

        System.out.printf("Sub list: %s%n", subList);
    }

    @RunThis("Collectors.maxBy() : Find the maximum")
    public static void maxBy() {
        Optional<Person> max = PersonProvider.personList().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));

        max.ifPresent(person -> System.out.printf("Max: %s%n", person));
    }

    @RunThis("max(): Find the maximum")
    public static void max() {
        Optional<Person> max = PersonProvider.personList().stream()
                .max(Comparator.comparing(Person::getAge));

        max.ifPresent(person -> System.out.printf("Max: %s%n", person));
    }

    @RunThis("sorted().findFirst(): Find the maximum")
    public static void sortAndMax() {
        Optional<Person> max = PersonProvider.personList().stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .findFirst();

        max.ifPresent(person -> System.out.printf("Max: %s%n", person));
    }

    @RunThis("Collectors.minBy(): Find the minimym")
    public static void minBy() {
        Optional<Person> min = PersonProvider.personList().stream()
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)));

        min.ifPresent(person -> System.out.printf("Min: %s%n", person));
    }

    @RunThis("Collectors.mapping(): Map and collect")
    public static void mapping() {
        List<Integer> ages = PersonProvider.personList().stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.mapping(Person::getAge, Collectors.toList()));

        System.out.printf("Ages: %s%n", ages);
    }

    @RunThis("Collectors.partitioningBy(): Partition as true and false")
    public static void partitioningBy() {
        Map<Boolean, List<Person>> partitioned = PersonProvider.personList().stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() < 30));

        partitioned.forEach(
                (partition, list) -> System.out.printf("Partition %s: %s%n", partition, list));
    }

    @RunThis("Collectors.reducing(): Reduce as sum")
    public static void reducing() {
        Integer sum = PersonProvider.personList().stream()
                .map(Person::getAge)
                .collect(Collectors.reducing(0, (age1, age2) -> age1 + age2));

        System.out.printf("Reduced sum: %s%n", sum);
    }

    @RunThis("sum(): Reduce as sum")
    public static void reduce_sum() {
        Integer sum = PersonProvider.personList().stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.printf("Reduced sum: %s%n", sum);
    }

    @RunThis("Collectors.summingInt()")
    public static void summingInt() {
        Integer sum = PersonProvider.personList().stream()
                .collect(Collectors.summingInt(Person::getAge));

        System.out.printf("Sum: %s%n", sum);
    }

    @RunThis("Collectors.summarizingInt(): Take sum, min, max and average")
    public static void summarizingInt() {
        IntSummaryStatistics summaryStatistics = PersonProvider.personList().stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.printf("Summary statistics: %s%n", summaryStatistics);
    }

    @RunThis("Collectors.summarizingDouble(): Take sum, min, max and average")
    public static void summarizingDouble() {
        DoubleSummaryStatistics summaryStatistics = PersonProvider.personList().stream()
                .collect(Collectors.summarizingDouble(Person::getAge));

        System.out.printf("Summary statistics: %s%n", summaryStatistics);
    }

    @RunThis("Collectors.joining(): Join stream elements")
    public static void joining() {
        String joined = PersonProvider.personList().stream()
                .map(Person::getName)
                .collect(Collectors.joining("-"));

        System.out.printf("Joined names: %s%n", joined);
    }

    @RunThis("Collectors.reducing(): Join stream elements")
    public static void joiningWithString() {
        String joined = PersonProvider.personList().stream()
                .map(Person::getName)
                .collect(Collectors.reducing("", (name1, name2) -> {
                    if (name1.isEmpty()) {
                        return name2;
                    } else {
                        return String.join("-", name1, name2);
                    }
                }));

        System.out.printf("Joined names: %s%n", joined);
    }

    @RunThis("reduce(): Join stream elements")
    public static void joiningWithStringJoiner() {
        String joined = PersonProvider.personList().stream()
                .map(Person::getName)
                .reduce("", (name1, name2) -> {
                    StringJoiner joiner = new StringJoiner("-");
                    if (!name1.isEmpty()) {
                        joiner.add(name1);
                    }

                    joiner.add(name2);
                    return joiner.toString();
                });

        System.out.printf("Joined names: %s%n", joined);
    }

    @RunThis("Custom collector")
    public static void collectCustom() {
        List<Person> collected = PersonProvider.personList().stream()
                .filter(Objects::nonNull)
                .collect(ArrayList::new, List::add,
                        (List<Person> left, List<Person> right) -> left.addAll(right));

        System.out.printf("Collected: %s%n", collected);
    }

    private CollectorOperations() {
    }
}
