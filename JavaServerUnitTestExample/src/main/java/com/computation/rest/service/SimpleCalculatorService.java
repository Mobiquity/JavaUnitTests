package com.computation.rest.service;

public interface SimpleCalculatorService {
	
	float add(float operand1, float operand2);

	float subtract(float operand1, float operand2);

	float multiply(float operand1, float operand2);

	float divison(float operand1, float operand2);

	float convertFahrenheit(float fahrenheit);
}
