package com.calculator.service;

public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {

	@Override
	public int add(int operand1, int operand2) {
		return operand1 + operand2;
	}

	@Override
	public int subtract(int operand1, int operand2) {
		return operand1 - operand2;
	}

	@Override
	public int multiply(int operand1, int operand2) {
		return operand1 * operand2;
	}

	@Override
	public int divison(int operand1, int operand2) {
		if (operand2 == 0) {
			throw new ArithmeticException("Divider can't be zero");
		}

		return operand1 / operand2;
	}

}
