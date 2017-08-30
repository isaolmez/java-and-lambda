package com.isa.java.lambda.general.approach9;

import com.isa.java.lambda.general.common.Person;
import java.util.List;

/**
 * Basic usage of lambdas with collections.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }
}
