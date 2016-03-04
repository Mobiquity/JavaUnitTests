package com.computation.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.service.ComputationService;

@Service
public class ComputationServiceImpl implements ComputationService {

	@Autowired
	private ComputationEngine computationEngine;
	
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
