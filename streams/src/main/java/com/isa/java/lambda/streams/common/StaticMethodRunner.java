package com.isa.java.lambda.streams.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Runs static methods that are annotated with @RunThis annotation.
 */
public class StaticMethodRunner {

    private StaticMethodRunner() {
    }

    public static <T> void run(Class<T> target) {
        getStaticMethods(target).stream()
                .filter(StaticMethodRunner::shouldBeRun)
                .forEach(StaticMethodRunner::runMethod);
    }

    private static <T> List<Method> getStaticMethods(Class<T> target) {
        return Arrays.stream(target.getDeclaredMethods())
                .filter(method -> Modifier.isStatic(method.getModifiers()))
                .collect(Collectors.toList());
    }

    private static boolean shouldBeRun(Method method) {
        return method.isAnnotationPresent(RunThis.class);
    }

    private static void runMethod(Method method) {
        try {
            RunThis annotation = method.getAnnotation(RunThis.class);
            System.out.printf("# %s %n", annotation.value());
            method.invoke(null);
            System.out.println();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MethodInvocationException("Error occurred when invoking method", e);
        }
    }

    private static class MethodInvocationException extends RuntimeException {

        MethodInvocationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
