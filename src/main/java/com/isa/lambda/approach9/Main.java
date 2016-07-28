package com.isa.lambda.approach9;

import java.util.List;

import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		roster
	    .stream()
	    .filter(
	        p -> p.getGender() == Person.Sex.MALE
	            && p.getAge() >= 18
	            && p.getAge() <= 25)
	    .map(p -> p.getEmailAddress())
	    .forEach(email -> System.out.println(email));
	}

}
