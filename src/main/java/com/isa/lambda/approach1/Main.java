package com.isa.lambda.approach1;

import java.util.List;

import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		printPersonsOlderThan(Person.createRoster(), 22);
	}

	/**
	 * This is the first approach 
	 */
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
}
