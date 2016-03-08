package com.junit.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.exception.mapper.ResultNotFoundException;
import com.computation.rest.service.ComputationService;
import com.computation.rest.service.impl.ComputationServiceImpl;

public class ComputationServiceTest {

    @InjectMocks 
    private static ComputationService computationService = new ComputationServiceImpl();

    @Mock 
    private static ComputationEngine computationEngine;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        setupMockMethods();
    }

    @Test
    public void testBasicAirthmeticOperation() {
        assertEquals(computationService.basicAirthmeticOperation("2*2"), "4");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    @Test
    public void testAddOperation() {
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    @Test
    public void testAddPositiveNumberToGreaterNegativeNumber() {
        assertEquals(computationService.basicAirthmeticOperation("-22 + 2"), "-20");
    }

    @Test
    public void testAddPositiveNumberToSmallerNegativeNumber() {
        assertEquals(computationService.basicAirthmeticOperation("-2 + 22"), "20");
    }

    @Test
    public void testAddZeroToNegativeNumber() {
        assertEquals(computationService.basicAirthmeticOperation("-22 + 0"), "-22");
    }

    @Test
    public void testAddZeroToPositiveNumber() {
        assertEquals(computationService.basicAirthmeticOperation("22 + 0"), "22");
    }
    
    @Test
    public void testSubstractFromGreaterNumber() {
        assertEquals(computationService.basicAirthmeticOperation("22 - 2"), "20");
    }
    
    @Test
    public void testSubstractNegativeNumberFromPositiveNumber() {
        assertEquals(computationService.basicAirthmeticOperation("22 - (-2)"), "24");
    }
    
    @Test
    public void testSubstractZeroFromPositiveNumber() {
        assertEquals(computationService.basicAirthmeticOperation("22 - 0"), "22");
    }
    
    @Test
    public void testSubstractPositiveNumberFromZero() {
        assertEquals(computationService.basicAirthmeticOperation("0 - 22"), "-22");
    }
    
    @Test
    public void testMultiplyWithTwoNegativeNumber() {
        assertEquals(computationService.basicAirthmeticOperation("-2*-2"), "4");
    }
    
    @Test
    public void testMultiplyNegativeAndPositiveNumber() {
        assertEquals(computationService.basicAirthmeticOperation("-2*2"), "-4");
    }
    
    @Test
    public void testMultiplyWithZero() {
        assertEquals(computationService.basicAirthmeticOperation("2*0"), "0");
    }
    
    @Test
    public void testConvertDecimalToBinary() {
        assertEquals(computationService.convertDecimalToBinary("219"), "11011011_2");
        assertEquals(computationService.convertDecimalToBinary("4242"), "1000010010010_2");
    }

    @Test
    public void testConvertUnitAndMeasure() {
        assertEquals(computationService.convertUnitAndMeasure("120 kilometers to meters"), "120000 meters");
        assertEquals(computationService.convertUnitAndMeasure("160 kilometers to miles"), "99.42 miles");
    }

    @Test(expected = ResultNotFoundException.class)
    public void testResultNotFoundException() {
        computationService.basicAirthmeticOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(");
    }

    @Test
    public void testIncompatibleConversion() {
        assertEquals(computationService.convertUnitAndMeasure("convert 1024 megabytes to miles"), " MB  (megabytes) and  miles are not compatible.");
    }

    private static void setupMockMethods() {
        when(computationEngine.computeOperation("2+22")).thenReturn("24");
        when(computationEngine.computeOperation("-22 + 2")).thenReturn("-20");
        when(computationEngine.computeOperation("-2 + 22")).thenReturn("20");
        when(computationEngine.computeOperation("-22 + 0")).thenReturn("-22");
        when(computationEngine.computeOperation("22 + 0")).thenReturn("22");
        
        when(computationEngine.computeOperation("22 - 2")).thenReturn("20");
        when(computationEngine.computeOperation("22 - (-2)")).thenReturn("24");
        when(computationEngine.computeOperation("22 - 0")).thenReturn("22");
        when(computationEngine.computeOperation("0 - 22")).thenReturn("-22");
        
        when(computationEngine.computeOperation("2*2")).thenReturn("4");
        when(computationEngine.computeOperation("-2*-2")).thenReturn("4");
        when(computationEngine.computeOperation("-2*2")).thenReturn("-4");
        when(computationEngine.computeOperation("2*0")).thenReturn("0");

        when(computationEngine.computeOperation("219 to binary")).thenReturn("11011011_2");
        when(computationEngine.computeOperation("4242 to binary")).thenReturn("1000010010010_2");

        when(computationEngine.computeOperation("120 kilometers to meters")).thenReturn("120000 meters");
        when(computationEngine.computeOperation("160 kilometers to miles")).thenReturn("99.42 miles");

        when(computationEngine.computeOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(")).thenThrow(new ResultNotFoundException("No result found for given query"));
        when(computationEngine.computeOperation("convert 1024 megabytes to miles")).thenReturn(" MB  (megabytes) and  miles are not compatible.");
    }
}
