package com.isa.java.lambda.streams.common;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class PersonProvider {

    private PersonProvider() {
    }

    public static List<Person> personList() {
        return ImmutableList.<Person>builder()
                .add(Person.builder().name("Isa").city("Izmir").age(32).married(true).build())
                .add(Person.builder().name("John").city("Madrid").age(21).married(false).build())
                .add(Person.builder().name("Edward").city("London").age(45).married(true).build())
                .add(Person.builder().name("Sally").city("Italy").age(21).married(false).build())
                .build();
    }
}
