package com.isa.java.lambda.syntax;

import java.util.function.Predicate;

public class LambdaSyntax {

    public static void main(String[] args) {
        /**
         * With a parameter type.
         * Implicit return.
         * There must be a single expression.
         */
        singleParam((String p) -> true, "Hello");

        /**
         * Without a parameter type.
         * Implicit return.
         */
        singleParam(p -> true, "Hello");

        /**
         * With braces.
         * Explicit return.
         */
        singleParam(p -> {
            System.out.println("Inside braces, single expression is determined by the braces");
            return true;
        }, "Hello");

        /**
         * With multiple parameters.
         */
        multipleParams((int... nums) -> {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            return sum;
        }, 1, 2, 3);

        /**
         * Can assign to references.
         * This references to a class that implements the Predicate interface.
         */
        Predicate<String> predicate = p -> true;
        System.out.println(predicate.test("Hi"));

    }

    public static <T> void singleParam(Predicate<T> predicate, T t) {
        if (predicate.test(t)) {
            System.out.println(t);
        }
    }

    public static <T> void multipleParams(MultipleParameterFunction multipleParams, int... numbers) {
        System.out.println(multipleParams.process(numbers));
    }

    @FunctionalInterface
    private interface MultipleParameterFunction {

        int process(int... num);
    }
}
