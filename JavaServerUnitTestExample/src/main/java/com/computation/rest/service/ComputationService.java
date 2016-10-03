package com.computation.rest.service;


public interface ComputationService {
	
	String basicAirthmeticOperation(String experssion);
	
	String convertDecimalToBinary(String experssion);
	
	String convertUnitAndMeasure(String experssion);
	
	String average(String type, String valueSet);
	
	String complexCalculation(String query);

	/**
	 * Return square root of given operand.
	 * 
	 * @param operand
	 * @return square root of operand
	 */
	Double sqrt(double operand);
}
