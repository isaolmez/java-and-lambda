package com.isa.lambda.approach6;

import java.util.List;
import java.util.function.Predicate;

import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		printPersons(Person.createRoster(), p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
	}

	public static void printPersons(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
}
