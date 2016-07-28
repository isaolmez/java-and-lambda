package com.isa.lambda.approach4;

import java.util.List;

import com.isa.lambda.model.CheckPerson;
import com.isa.lambda.model.Person;

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
