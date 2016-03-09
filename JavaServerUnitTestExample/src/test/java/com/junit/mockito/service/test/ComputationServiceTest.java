package com.junit.mockito.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.exception.mapper.ResultNotFoundException;
import com.computation.rest.service.ComputationService;
import com.computation.rest.service.impl.ComputationServiceImpl;

/**
 * This class demonstrate how to use Mockito framework and write unit testcase for a service layer.
 * The MockitoJUnitRunner class of Mockito framework creates mocks and spies instances for all 
 * fields that are annotated with the @Mock annotations. 
 * 
 * @author chintandwivedi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ComputationServiceTest {

    /**
     * @Mock annotation - Allows shorthand mock creation. Minimizes repetitive mock creation code.
     */
    @Mock 
    private ComputationEngine computationEngine;

    private ComputationService computationService;
    
    /**
     * Invoke this method before a test case method execute.
     */
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        computationService = new ComputationServiceImpl(computationEngine);
    }

    @Test
    public void testBasicAirthmeticOperation() {
    	when(computationEngine.computeOperation("2+22")).thenReturn("24");
    	when(computationEngine.computeOperation("2*2")).thenReturn("4");
    	
        assertEquals(computationService.basicAirthmeticOperation("2*2"), "4");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    @Test
    public void testAddOperation() {
    	when(computationEngine.computeOperation("2+22")).thenReturn("24");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    @Test
    public void testAddPositiveNumberToGreaterNegativeNumber() {
    	when(computationEngine.computeOperation("-22 + 2")).thenReturn("-20");
        assertEquals(computationService.basicAirthmeticOperation("-22 + 2"), "-20");
    }

    @Test
    public void testAddPositiveNumberToSmallerNegativeNumber() {
    	when(computationEngine.computeOperation("-2 + 22")).thenReturn("20");
        assertEquals(computationService.basicAirthmeticOperation("-2 + 22"), "20");
    }

    @Test
    public void testAddZeroToNegativeNumber() {
    	when(computationEngine.computeOperation("-22 + 0")).thenReturn("-22");
        assertEquals(computationService.basicAirthmeticOperation("-22 + 0"), "-22");
    }

    @Test
    public void testAddZeroToPositiveNumber() {
    	when(computationEngine.computeOperation("22 + 0")).thenReturn("22");
        assertEquals(computationService.basicAirthmeticOperation("22 + 0"), "22");
    }
    
    @Test
    public void testSubstractFromGreaterNumber() {
    	when(computationEngine.computeOperation("22 - 2")).thenReturn("20");
        assertEquals(computationService.basicAirthmeticOperation("22 - 2"), "20");
    }
    
    @Test
    public void testSubstractNegativeNumberFromPositiveNumber() {
    	when(computationEngine.computeOperation("22 - (-2)")).thenReturn("24");
        assertEquals(computationService.basicAirthmeticOperation("22 - (-2)"), "24");
    }
    
    @Test
    public void testSubstractZeroFromPositiveNumber() {
    	when(computationEngine.computeOperation("22 - 0")).thenReturn("22");
        assertEquals(computationService.basicAirthmeticOperation("22 - 0"), "22");
    }
    
    @Test
    public void testSubstractPositiveNumberFromZero() {
    	when(computationEngine.computeOperation("0 - 22")).thenReturn("-22");
        assertEquals(computationService.basicAirthmeticOperation("0 - 22"), "-22");
    }
    
    @Test
    public void testMultiplyWithTwoNegativeNumber() {
    	when(computationEngine.computeOperation("-2*-2")).thenReturn("4");
        assertEquals(computationService.basicAirthmeticOperation("-2*-2"), "4");
    }
    
    @Test
    public void testMultiplyNegativeAndPositiveNumber() {
    	when(computationEngine.computeOperation("-2*2")).thenReturn("-4");
        assertEquals(computationService.basicAirthmeticOperation("-2*2"), "-4");
    }
    
    @Test
    public void testMultiplyWithZero() {
    	when(computationEngine.computeOperation("2*0")).thenReturn("0");
        assertEquals(computationService.basicAirthmeticOperation("2*0"), "0");
    }
    
    @Test
    public void testConvertDecimalToBinary() {
    	when(computationEngine.computeOperation("219 to binary")).thenReturn("11011011_2");
        when(computationEngine.computeOperation("4242 to binary")).thenReturn("1000010010010_2");
        when(computationEngine.computeOperation("-219 to binary")).thenReturn("-11011011_2");
         
        assertEquals(computationService.convertDecimalToBinary("219"), "11011011_2");
        assertEquals(computationService.convertDecimalToBinary("-219"), "-11011011_2");
        assertEquals(computationService.convertDecimalToBinary("4242"), "1000010010010_2");
    }

    @Test
    public void testConvertUnitAndMeasure() {
        when(computationEngine.computeOperation("120 kilometers to meters")).thenReturn("120000 meters");
        when(computationEngine.computeOperation("160 kilometers to miles")).thenReturn("99.42 miles");
        
        assertEquals(computationService.convertUnitAndMeasure("120 kilometers to meters"), "120000 meters");
        assertEquals(computationService.convertUnitAndMeasure("160 kilometers to miles"), "99.42 miles");
    }

    @Test(expected = ResultNotFoundException.class)
    public void testResultNotFoundException() {
    	when(computationEngine.computeOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(")).thenThrow(new ResultNotFoundException("No result found for given query"));
        computationService.basicAirthmeticOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(");
    }

    @Test
    public void testIncompatibleConversion() {
    	when(computationEngine.computeOperation("convert 1024 megabytes to miles")).thenReturn(" MB  (megabytes) and  miles are not compatible.");
        assertEquals(computationService.convertUnitAndMeasure("convert 1024 megabytes to miles"), " MB  (megabytes) and  miles are not compatible.");
    }

}
