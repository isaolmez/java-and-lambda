package com.isa.java.lambda.general.approach3;

import com.isa.java.lambda.general.common.CheckPerson;
import com.isa.java.lambda.general.common.Person;
import java.util.List;

/**
 * Pass the strategy as pre-defined class implementing user-defined interface.
 */
public class Main {

    public static void main(String[] args) {
        printPersons(Person.createRoster(), new AgeBasedEligibilityCheck());
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
