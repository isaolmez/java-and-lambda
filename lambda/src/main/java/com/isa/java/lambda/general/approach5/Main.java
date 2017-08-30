package com.isa.java.lambda.general.approach5;

import com.isa.java.lambda.general.common.Person;
import com.isa.java.lambda.general.common.Person.Sex;
import java.util.List;

import com.isa.java.lambda.general.common.CheckPerson;

/**
 * Pass the strategy as lambda implementing user-defined interface.
 */
public class Main {

    public static void main(String[] args) {
        printPersons(Person.createRoster(),
                (Person p) -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        printPersons(Person.createRoster(),
                p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
