package com.computation.rest.service.impl;

import com.computation.rest.service.SimpleCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {

	@Override
	public float add(float operand1, float operand2) {
		return operand1 + operand2;
	}

	@Override
	public float subtract(float operand1, float operand2) {
		return operand1 - operand2;
	}

	@Override
	public float multiply(float operand1, float operand2) {
		return operand1 * operand2;
	}

	@Override
	public float divison(float operand1, float operand2) {
		if (operand2 == 0) {
			throw new ArithmeticException("Divider can't be zero");
		}

		return operand1 / operand2;
	}

	@Override
	public float convertFahrenheit(final float fahrenheit) {
		//formula to convert fahrenheit to degrees
		//T(°C) = (T(°F) - 32) × 5/9
		return ((subtract(fahrenheit, 32)) * divison(5, 9));
	}
}
