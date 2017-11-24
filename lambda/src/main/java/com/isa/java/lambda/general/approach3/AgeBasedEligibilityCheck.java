package com.isa.java.lambda.general.approach3;

import com.isa.java.lambda.general.common.CheckPerson;
import com.isa.java.lambda.general.common.Person;

class AgeBasedEligibilityCheck implements CheckPerson {

    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
}