package com.computation.rest.validator;

public class InputValidator {

	private static final String INTEGER_REGEX = "^\\d+$";

	public static boolean validValueForBinaryConversion(String input) {
		try {
			if (input != null && input.matches(INTEGER_REGEX)) {
				return true;
			}
		} catch (Exception exc) {  }
		return false;
	}

}
