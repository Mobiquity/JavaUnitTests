package com.computation.rest.service;


public interface ComputationService {
	
	String basicArithmeticOperation(String expression);
	
	String convertDecimalToBinary(String expression);
	
	String convertUnitAndMeasure(String expression);
	
	String average(String type, String valueSet);
	
	String complexCalculation(String query);

	String computeMean(String type, String valueSet);

	String computeTrigonometricFunction(String expression);

	Double computeRadian(Double value);
}
