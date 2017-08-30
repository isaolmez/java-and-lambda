package com.isa.java.lambda.streams;

import com.isa.java.lambda.streams.common.StaticMethodRunner;
import com.isa.java.lambda.streams.feature.CollectorOperations;
import com.isa.java.lambda.streams.feature.IntStreamOperations;
import com.isa.java.lambda.streams.feature.StreamOperations;

public class Application {

    public static void main(String[] args) {
        StaticMethodRunner.run(CollectorOperations.class);
        StaticMethodRunner.run(StreamOperations.class);
        StaticMethodRunner.run(IntStreamOperations.class);
    }
}
