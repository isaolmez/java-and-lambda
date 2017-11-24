package com.isa.java.lambda.general.approach7;

import com.isa.java.lambda.general.common.Person;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Pass multiple strategies with lambdas implementing different jdk-defined functional interfaces.
 */
public class Main {

    public static void main(String[] args) {
        processPersons(Person.createRoster(), p -> true, p -> p.printPerson());
        processPersonsWithFunction(Person.createRoster(), p -> true, p -> p.getEmailAddress(),
                data -> System.out.println(data));
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
            Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}
