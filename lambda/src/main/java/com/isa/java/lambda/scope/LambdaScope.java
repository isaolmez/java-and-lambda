package com.isa.java.lambda.scope;

import java.util.function.Consumer;

public class LambdaScope {

    public int x = 0;

    public static void main(String... args) {
        LambdaScope st = new LambdaScope();
        LambdaScope.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {

            // The following statement causes the compiler to generate.
            // x = 99;

            Consumer<Integer> myConsumer = y ->
            {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScope.this.x = " + LambdaScope.this.x);
            };

            myConsumer.accept(x);
        }
    }
}