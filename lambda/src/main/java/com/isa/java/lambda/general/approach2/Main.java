package com.isa.java.lambda.general.approach2;

import com.isa.java.lambda.general.common.Person;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printPersonsWithinAgeRange(Person.createRoster(), 22, 55);
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
}
