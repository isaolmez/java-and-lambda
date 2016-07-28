package com.isa.lambda.approach3;

import com.isa.lambda.model.CheckPerson;
import com.isa.lambda.model.Person;

class CheckPersonEligibleForSelectiveService implements CheckPerson {
	public boolean test(Person p) {
		return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
	}
}