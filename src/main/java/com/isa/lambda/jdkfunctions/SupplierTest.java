package com.isa.lambda.jdkfunctions;

import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		supplierTest(() -> "Hello World");
		supplierTest(() -> {
			return "Hello World";
		});
	}

	public static <T> void supplierTest(Supplier<T> supplier) {
		T result = supplier.get();
		System.out.println(result);
	}
}
