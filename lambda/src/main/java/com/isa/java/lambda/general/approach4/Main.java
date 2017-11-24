package com.isa.java.lambda.general.approach4;

import com.isa.java.lambda.general.common.CheckPerson;
import com.isa.java.lambda.general.common.Person;
import java.util.List;

/**
 * Pass the strategy as anonymous class implementing user-defined interface.
 */
public class Main {

    public static void main(String[] args) {
        printPersons(Person.createRoster(), new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}
