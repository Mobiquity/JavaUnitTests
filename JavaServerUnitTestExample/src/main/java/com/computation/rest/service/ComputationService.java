package com.computation.rest.service;


public interface ComputationService {
	
	String basicAirthmeticOperation(String experssion);
	
	String convertDecimalToBinary(String experssion);
	
	String convertUnitAndMeasure(String experssion);
	
	String average(String type, String valueSet);
	
	String complexCalculation(String query);

	String computeModulo(String value);

	Double computeAbsolute(Double value);
}
