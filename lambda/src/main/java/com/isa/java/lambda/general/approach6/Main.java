package com.isa.java.lambda.general.approach6;

import com.isa.java.lambda.general.common.Person;
import com.isa.java.lambda.general.common.Person.Sex;
import java.util.List;
import java.util.function.Predicate;

/**
 * Pass the strategy as lambda implementing jdk-defined Predicate interface.
 */
public class Main {

    public static void main(String[] args) {
        printPersons(Person.createRoster(),
                p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    public static void printPersons(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
