package com.computation.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.service.ComputationService;

@Service
public class ComputationServiceImpl implements ComputationService {

	private static final String TO_BINARY = " to binary";
	
	private ComputationEngine computationEngine;
	
	@Autowired
	public ComputationServiceImpl(ComputationEngine computationEngine) {
		this.computationEngine = computationEngine;
	}

	@Override
	public String basicAirthmeticOperation(String experssion) {
		return computationEngine.computeOperation(experssion);
	}

	@Override
	public String convertDecimalToBinary(String experssion) {
		return computationEngine.computeOperation(experssion + TO_BINARY);
	}

	@Override
	public String convertUnitAndMeasure(String experssion) {
		return computationEngine.computeOperation(experssion);
	}
}
