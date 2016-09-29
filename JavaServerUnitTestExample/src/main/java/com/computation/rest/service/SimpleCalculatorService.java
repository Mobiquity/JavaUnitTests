package com.computation.rest.service;

public interface SimpleCalculatorService {
	
	float add(float operand1, float operand2);

	float subtract(float operand1, float operand2);

	float multiply(float operand1, float operand2);

	float divison(float operand1, float operand2);
	   
	/**
	 * Return square root of given operand.
	 * 
	 * @param operand
	 * @return square root of operand
	 */
	Double sqrt(double operand);
}
