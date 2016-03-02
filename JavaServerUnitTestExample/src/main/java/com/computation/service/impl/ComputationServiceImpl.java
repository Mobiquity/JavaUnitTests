package com.computation.service.impl;

import com.computation.rest.engine.ComputationEngine;
import com.computation.service.ComputationService;

public class ComputationServiceImpl implements ComputationService {

	private ComputationEngine computationEngine;
	
	public ComputationServiceImpl(ComputationEngine computationEngine) {
		this.computationEngine = computationEngine;
	}
	
	@Override
	public String basicAirthmeticOperation(String experssion) {
		return computationEngine.computeOperation(experssion);
	}

	@Override
	public String convertDecimalToBinary(String experssion) {
		return computationEngine.computeOperation(experssion);
	}

	@Override
	public String convertUnitAndMeasure(String experssion) {
		return computationEngine.computeOperation(experssion);
	}
}
