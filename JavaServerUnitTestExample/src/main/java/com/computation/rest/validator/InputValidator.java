package com.computation.rest.validator;

public class InputValidator {

	private static final String INTEGER_REGEX = "^\\d+$";
	
	private static final String FLOAT_REGEX = "^[-+]?[0-9]*\\.?[0-9]+$";

	public static boolean validValueForBinaryConversion(String input) {
		try {
			if (input != null && input.length() > 0  && input.matches(INTEGER_REGEX)) {
				return true;
			}
		} catch (Exception exc) {
		}
		return false;
	}

	public static boolean validIntegerValue(String input) {
		try {
			if (input != null && input.length() > 0 && input.matches(INTEGER_REGEX)) {
				return true;
			}
		} catch (Exception exc) {
		}
		return false;
	}
	
	public static boolean validFloatValue(String input) {
		try {
			if (!isEmptyString(input)  && input.matches(FLOAT_REGEX)) {
				return true;
			}
		} catch (Exception exc) {
		}
		return false;
	}
	
	public static boolean isEmptyString(String input) {
		if(input == null || input.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidValueSet(String valueSet) {
		if(!valueSet.startsWith("{") || !valueSet.endsWith("}")) {
			return false;
		}
		String[] values = valueSet.substring(1, valueSet.length()-1).split(",");
		for (String floatValue : values) {
			if(!validFloatValue(floatValue.trim())){
				return false;
			}
		}
		
		return true;
	}
	
}
