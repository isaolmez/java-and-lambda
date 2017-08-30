package com.isa.java.lambda.collections;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamOperations {

    private static final BasicStreamOperations OPERATIONS = new BasicStreamOperations();

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("john");
        names.add("jane");
        names.add("jacky");

        out.println(OPERATIONS.collect(names));
        out.println(OPERATIONS.collect(names));
        out.println(OPERATIONS.collectCustom(names));
        out.println(OPERATIONS.groupBy(names));
    }

    public <T> Stream<T> filter(List<T> list) {
        return list.stream().filter(item -> item != null);
    }

    public <T> List<T> collect(List<T> list) {
        return list.stream().filter(item -> item != null).collect(Collectors.toList());
    }

    public <T> List<T> collectCustom(List<T> list) {
        return list.stream()
                .filter(item -> item != null)
                .collect(ArrayList::new, List::add, (List<T> left, List<T> right) -> {
                    left.addAll(right);
                });
    }

    public Map<Integer, List<String>> groupBy(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(String::length));
    }
}
