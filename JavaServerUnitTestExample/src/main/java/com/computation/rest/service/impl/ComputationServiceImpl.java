package com.computation.rest.service.impl;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.service.ComputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputationServiceImpl implements ComputationService {

    private static final String TO_BINARY = " to binary";

    private ComputationEngine computationEngine;

    @Autowired
    public ComputationServiceImpl(ComputationEngine computationEngine) {
        this.computationEngine = computationEngine;
    }

    @Override
    public String basicArithmeticOperation(String expression) {
        return computationEngine.computeOperation(expression);
    }

    @Override
    public String convertDecimalToBinary(String expression) {
        return computationEngine.computeOperation(expression + TO_BINARY);
    }

    @Override
    public String convertUnitAndMeasure(String expression) {
        return computationEngine.computeUnitConversion(expression);
    }

    public String average(String type, String valueSet) {
        return computationEngine.computeOperation(type + " " + valueSet);
    }

    public String complexCalculation(String query) {
        return computationEngine.computeOperation(query);
    }

    @Override
    public String computeMean(String type, String valueSet) {
        return computationEngine.computeOperation(type + " (" + valueSet + ")");
    }

    @Override
    public String computeTrigonometricFunction(String expression) {
        return computationEngine.computeOperation(expression);
    }

    @Override
    public Double computeRadian(Double value) {
        return computationEngine.computeRadian(value);
    }

}
