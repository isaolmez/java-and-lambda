package com.isa.java.lambda.streams.feature;

import com.isa.java.lambda.streams.common.Person;
import com.isa.java.lambda.streams.common.PersonProvider;
import com.isa.java.lambda.streams.common.RunThis;
import com.isa.java.lambda.streams.common.StaticMethodRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class CustomCollectorOperations {

    private CustomCollectorOperations() {
    }

    public static void main(String[] args) {
        StaticMethodRunner.run(CustomCollectorOperations.class);
    }

    @RunThis("Custom collector")
    public static void collectCustom() {
        List<Person> collected = PersonProvider.personList().stream()
                .filter(Objects::nonNull)
                .collect(ArrayList::new, List::add,
                        (List<Person> left, List<Person> right) -> left.addAll(right));

        System.out.printf("Collected: %s%n", collected);
    }

    @RunThis("Custom collector class")
    public static void collectCustomClass() {

        class CustomConsumer implements Consumer<Person> {

            private List<Person> personList = new ArrayList<>();

            @Override
            public void accept(Person person) {
                personList.add(person);
            }

            public void combine(CustomConsumer other) {
                this.personList.addAll(other.personList);
            }
        }

        CustomConsumer result = PersonProvider.personList().stream()
                .filter(Objects::nonNull)
                .collect(CustomConsumer::new, CustomConsumer::accept, CustomConsumer::combine);

        System.out.printf("Collected: %s%n", result.personList);
    }

    @RunThis("Custom collector class that provides multiple reductions")
    public static void collectCustomClassWithMultipleReductions() {

        class Metrics implements IntConsumer {

            private int count;
            private int sum;
            private int average;
            private int max = 0;
            private int min = Integer.MAX_VALUE;

            @Override
            public void accept(int value) {
                count++;
                sum += value;
                max = Math.max(max, value);
                min = Math.min(min, value);
            }

            public void combine(Metrics metrics) {
                average += metrics.average;
                sum += metrics.sum;
                max = Math.max(max, metrics.max);
                min = Math.min(min, metrics.min);
            }

            public int getCount() {
                return count;
            }

            public int getSum() {
                return sum;
            }

            public int getAverage() {
                return sum / average;
            }

            public int getMax() {
                return max;
            }

            public int getMin() {
                return min;
            }

            @Override
            public String toString() {
                return "Metrics{" +
                        "count=" + count +
                        ", sum=" + sum +
                        ", average=" + average +
                        ", max=" + max +
                        ", min=" + min +
                        '}';
            }
        }

        Metrics result = PersonProvider.personList().stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::getSalary)
                .collect(Metrics::new, Metrics::accept, Metrics::combine);

        System.out.printf("Collected: %s%n", result);
    }
}
