package com.isa.lambda.approach2;

import java.util.List;

import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		printPersonsWithinAgeRange(Person.createRoster(), 22, 55);
	}

	public static void printPersonsWithinAgeRange(
		    List<Person> roster, int low, int high) {
		    for (Person p : roster) {
		        if (low <= p.getAge() && p.getAge() < high) {
		            p.printPerson();
		        }
		    }
		}
}
