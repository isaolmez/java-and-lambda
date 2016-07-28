package com.isa.lambda.approach8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.isa.lambda.model.Person;

public class Main {
	public static void main(String[] args) {
		processElements(Person.createRoster(), p -> true, p -> p.getEmailAddress(), data -> System.out.println(data));
	}

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}
