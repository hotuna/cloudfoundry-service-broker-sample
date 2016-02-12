package com.bong.calculator.model;

public class Calculator {

	public Calculator() {
	}

	public double calculate(String operation) {

		String[] numbers = operation.split("\\D+");

		for (String i : numbers) {
			operation = operation.replaceFirst(i, " ");
		}
		operation = operation.replaceFirst(" ", "");
		String[] digits = operation.split(" ");

		double result = 0;

		for (int i = 0; i < digits.length; i++) {
			if (i == 0) {
				result = calculate(digits[i], Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
			} else {
				result = calculate(digits[i], result, Double.parseDouble(numbers[i + 1]));
			}
		}

		return result;
	}

	private double calculate(String operation, double a, double b) {
		switch (operation) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
		}
		return 0;
	}

}
