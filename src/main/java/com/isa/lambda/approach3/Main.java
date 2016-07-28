package com.isa.lambda.approach3;

import java.util.List;

import com.isa.lambda.model.CheckPerson;
import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		printPersons(Person.createRoster(), new CheckPersonEligibleForSelectiveService());
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
}
