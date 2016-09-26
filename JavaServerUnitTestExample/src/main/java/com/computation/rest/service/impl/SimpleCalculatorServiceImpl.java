package com.computation.rest.service.impl;

import org.springframework.stereotype.Service;

import com.computation.rest.service.SimpleCalculatorService;

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
	public long square(int operand1) {
		return operand1 * operand1;
	}

}
