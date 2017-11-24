package com.isa.java.lambda.streams.inference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laziness {

    public static void main(String[] args) {
        try {
            List<String> names = new ArrayList<>(Arrays.asList("john", "jane"));

            String concatenatedString = names
                    .stream()
                    // Don't do this! Interference occurs here.
                    .peek(s -> names.add("jack"))
                    .reduce((a, b) -> a + " " + b)
                    .get();

            System.out.println("Concatenated string: " + concatenatedString);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }
}
