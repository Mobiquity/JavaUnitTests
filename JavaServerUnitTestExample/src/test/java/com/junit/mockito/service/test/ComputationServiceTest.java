package com.junit.mockito.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
        computationService = new ComputationServiceImpl(computationEngine);
    }

    /**
     * Test basic arithmetic operation for multiplication and addition.
     */
    @Test
    public void testBasicArithmeticOperation() {
    	when(computationEngine.computeOperation("2+22")).thenReturn("24");
    	when(computationEngine.computeOperation("2*2")).thenReturn("4");
    	
        assertEquals(computationService.basicAirthmeticOperation("2*2"), "4");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    /**
     * Test add operation for two positive values.
     */
    @Test
    public void testAddOperation() {
    	when(computationEngine.computeOperation("2+22")).thenReturn("24");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    /**
     * Test add operation for one negative number and positive number.
     * The negative number is greater and positive number value. 
     */
    @Test
    public void testAddPositiveNumberToGreaterNegativeNumber() {
    	when(computationEngine.computeOperation("-22 + 2")).thenReturn("-20");
        assertEquals(computationService.basicAirthmeticOperation("-22 + 2"), "-20");
    }

    /**
     * Test add operation for greater positive number and negative number.
     */
    @Test
    public void testAddPositiveNumberToSmallerNegativeNumber() {
    	when(computationEngine.computeOperation("-2 + 22")).thenReturn("20");
        assertEquals(computationService.basicAirthmeticOperation("-2 + 22"), "20");
    }

    /**
     *  Test add operation to add a zero value to negative number.
     */
    @Test
    public void testAddZeroToNegativeNumber() {
    	when(computationEngine.computeOperation("-22 + 0")).thenReturn("-22");
        assertEquals(computationService.basicAirthmeticOperation("-22 + 0"), "-22");
    }

    /**
     * Test add operation to add a zero value to positive number.
     */
    @Test
    public void testAddZeroToPositiveNumber() {
    	when(computationEngine.computeOperation("22 + 0")).thenReturn("22");
        assertEquals(computationService.basicAirthmeticOperation("22 + 0"), "22");
    }
    
    /**
     *  Test subtract smaller number from greater number. 
     */
    @Test
    public void testSubstractFromGreaterNumber() {
    	when(computationEngine.computeOperation("22 - 2")).thenReturn("20");
        assertEquals(computationService.basicAirthmeticOperation("22 - 2"), "20");
    }
    
    /**
     *  Test subtract smaller number from greater number. 
     */
    @Test
    public void testSubstractNegativeNumberFromPositiveNumber() {
    	when(computationEngine.computeOperation("22 - (-2)")).thenReturn("24");
        assertEquals(computationService.basicAirthmeticOperation("22 - (-2)"), "24");
    }
    
    /**
     *  Test subtract zero from positive number. 
     */
    @Test
    public void testSubstractZeroFromPositiveNumber() {
    	when(computationEngine.computeOperation("22 - 0")).thenReturn("22");
        assertEquals(computationService.basicAirthmeticOperation("22 - 0"), "22");
    }
    
    /**
     *  Test subtract negative number from zero. 
     */
    @Test
    public void testSubstractPositiveNumberFromZero() {
    	when(computationEngine.computeOperation("0 - 22")).thenReturn("-22");
        assertEquals(computationService.basicAirthmeticOperation("0 - 22"), "-22");
    }
    
    /**
     *  Test multiply two negative numbers 
     */
   @Test
    public void testMultiplyWithTwoNegativeNumber() {
    	when(computationEngine.computeOperation("-2*-2")).thenReturn("4");
        assertEquals(computationService.basicAirthmeticOperation("-2*-2"), "4");
    }
    
   /**
    *  Test multiply negative number and positive number 
    */
   @Test
    public void testMultiplyNegativeAndPositiveNumber() {
    	when(computationEngine.computeOperation("-2*2")).thenReturn("-4");
        assertEquals(computationService.basicAirthmeticOperation("-2*2"), "-4");
    }
    
   /**
    *  Test multiply positive number with zero 
    */
    @Test
    public void testMultiplyWithZero() {
    	when(computationEngine.computeOperation("2*0")).thenReturn("0");
        assertEquals(computationService.basicAirthmeticOperation("2*0"), "0");
    }
    
    /**
     * Test converting numeric value to binary.
     */
    @Test
    public void testConvertDecimalToBinary() {
    	when(computationEngine.computeOperation("219 to binary")).thenReturn("11011011_2");
        when(computationEngine.computeOperation("4242 to binary")).thenReturn("1000010010010_2");
        when(computationEngine.computeOperation("-219 to binary")).thenReturn("-11011011_2");
         
        assertEquals(computationService.convertDecimalToBinary("219"), "11011011_2");
        assertEquals(computationService.convertDecimalToBinary("-219"), "-11011011_2");
        assertEquals(computationService.convertDecimalToBinary("4242"), "1000010010010_2");
    }

    /**
     * Test converting unit to another compatible unit type.
     */
    @Test
    public void testConvertUnitAndMeasure() {
        when(computationEngine.computeUnitConversion("120 kilometers to meters")).thenReturn("120000 meters");
        when(computationEngine.computeUnitConversion("160 kilometers to miles")).thenReturn("99.42 miles");
        
        assertEquals(computationService.convertUnitAndMeasure("120 kilometers to meters"), "120000 meters");
        assertEquals(computationService.convertUnitAndMeasure("160 kilometers to miles"), "99.42 miles");
    }

    /**
     * Test exception condition when passing invalid data type value. 
     */
    @Test(expected = ResultNotFoundException.class)
    public void testResultNotFoundException() {
    	when(computationEngine.computeOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(")).thenThrow(new ResultNotFoundException("No result found for given query"));
        computationService.basicAirthmeticOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(");
    }

    /**
     * Test to convert incompatible unit type.
     */
    @Test
    public void testIncompatibleConversion() {
    	when(computationEngine.computeUnitConversion("convert 1024 megabytes to miles")).thenReturn(" MB  (megabytes) and  miles are not compatible.");
        assertEquals(computationService.convertUnitAndMeasure("convert 1024 megabytes to miles"), " MB  (megabytes) and  miles are not compatible.");
    }
    
    @Test
    public void testSquareRoot() {
    	when(computationEngine.sqrt(81)).thenReturn(9.0);
        assertEquals(computationService.sqrt(81), 9, 0);
    }
    
    @Test
    public void testCube() {
    	when(computationEngine.computeOperation("cube of 2")).thenReturn("8");
        assertEquals(computationService.complexCalculation("cube of 2"), "8");
    }
    
    @Test
    public void testAverageCalculation() {
    	
    }

}
