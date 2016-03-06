package com.computation.rest.validator;

public class InputValidator {

	public static boolean validValueForBinaryConversion(String input) {
		//TODO: enter validation for valid number value.
		try{
			int val = Integer.parseInt(input);
		}catch(Exception exc) {
			return false;
		}
		return true;
	}
}
