package com.isa.java.lambda.streams.common;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class PersonProvider {

    private PersonProvider() {
    }

    public static List<Person> personList() {
        return ImmutableList.<Person>builder()
                .add(Person.builder().name("Isa").city("Izmir").age(32).married(true).salary(1000).build())
                .add(Person.builder().name("John").city("Madrid").age(21).married(false).salary(2000).build())
                .add(Person.builder().name("Edward").city("London").age(45).married(true).salary(2000).build())
                .add(Person.builder().name("Sally").city("Italy").age(21).married(false).salary(3000).build())
                .build();
    }
}
