package com.isa.java.lambda.general.approach1;

import com.isa.java.lambda.general.common.Person;
import java.util.List;

/**
 * This is the first classic approach.
 */
public class Main {

    public static void main(String[] args) {
        printPersonsOlderThan(Person.createRoster(), 22);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
}
