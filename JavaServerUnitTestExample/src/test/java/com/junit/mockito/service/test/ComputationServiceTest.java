package com.junit.mockito.service.test;

import com.computation.rest.engine.ComputationEngine;
import com.computation.rest.exception.mapper.ResultNotFoundException;
import com.computation.rest.service.ComputationService;
import com.computation.rest.service.impl.ComputationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * This class demonstrate how to use Mockito framework and write unit testcase for a service layer.
 * The MockitoJUnitRunner class of Mockito framework creates mocks and spies instances for all
 * fields that are annotated with the @Mock annotations.
 *
 * @author chintandwivedi
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

        assertEquals(computationService.basicArithmeticOperation("2*2"), "4");
        assertEquals(computationService.basicArithmeticOperation("2+22"), "24");
    }

    /**
     * Test add operation for two positive values.
     */
    @Test
    public void testAddOperation() {
        when(computationEngine.computeOperation("2+22")).thenReturn("24");
        assertEquals(computationService.basicArithmeticOperation("2+22"), "24");
    }

    /**
     * Test add operation for one negative number and positive number.
     * The negative number is greater and positive number value.
     */
    @Test
    public void testAddPositiveNumberToGreaterNegativeNumber() {
        when(computationEngine.computeOperation("-22 + 2")).thenReturn("-20");
        assertEquals(computationService.basicArithmeticOperation("-22 + 2"), "-20");
    }

    /**
     * Test add operation for greater positive number and negative number.
     */
    @Test
    public void testAddPositiveNumberToSmallerNegativeNumber() {
        when(computationEngine.computeOperation("-2 + 22")).thenReturn("20");
        assertEquals(computationService.basicArithmeticOperation("-2 + 22"), "20");
    }

    /**
     * Test add operation to add a zero value to negative number.
     */
    @Test
    public void testAddZeroToNegativeNumber() {
        when(computationEngine.computeOperation("-22 + 0")).thenReturn("-22");
        assertEquals(computationService.basicArithmeticOperation("-22 + 0"), "-22");
    }

    /**
     * Test add operation to add a zero value to positive number.
     */
    @Test
    public void testAddZeroToPositiveNumber() {
        when(computationEngine.computeOperation("22 + 0")).thenReturn("22");
        assertEquals(computationService.basicArithmeticOperation("22 + 0"), "22");
    }

    /**
     * Test subtract smaller number from greater number.
     */
    @Test
    public void testSubtractFromGreaterNumber() {
        when(computationEngine.computeOperation("22 - 2")).thenReturn("20");
        assertEquals(computationService.basicArithmeticOperation("22 - 2"), "20");
    }

    /**
     * Test subtract smaller number from greater number.
     */
    @Test
    public void testSubtractNegativeNumberFromPositiveNumber() {
        when(computationEngine.computeOperation("22 - (-2)")).thenReturn("24");
        assertEquals(computationService.basicArithmeticOperation("22 - (-2)"), "24");
    }

    /**
     * Test subtract zero from positive number.
     */
    @Test
    public void testSubtractZeroFromPositiveNumber() {
        when(computationEngine.computeOperation("22 - 0")).thenReturn("22");
        assertEquals(computationService.basicArithmeticOperation("22 - 0"), "22");
    }

    /**
     * Test subtract negative number from zero.
     */
    @Test
    public void testSubstractPositiveNumberFromZero() {
        when(computationEngine.computeOperation("0 - 22")).thenReturn("-22");
        assertEquals(computationService.basicArithmeticOperation("0 - 22"), "-22");
    }

    /**
     * Test multiply two negative numbers
     */
    @Test
    public void testMultiplyWithTwoNegativeNumber() {
        when(computationEngine.computeOperation("-2*-2")).thenReturn("4");
        assertEquals(computationService.basicArithmeticOperation("-2*-2"), "4");
    }

    /**
     * Test multiply negative number and positive number
     */
    @Test
    public void testMultiplyNegativeAndPositiveNumber() {
        when(computationEngine.computeOperation("-2*2")).thenReturn("-4");
        assertEquals(computationService.basicArithmeticOperation("-2*2"), "-4");
    }

    /**
     * Test multiply positive number with zero
     */
    @Test
    public void testMultiplyWithZero() {
        when(computationEngine.computeOperation("2*0")).thenReturn("0");
        assertEquals(computationService.basicArithmeticOperation("2*0"), "0");
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
        computationService.basicArithmeticOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(");
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
    public void testAverageCalculation() {

    }

    /**
     * Test to check the mean of the numbers
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testMeanCalculation() {
        when(computationEngine.computeOperation("Geometric Mean (3,3)")).thenReturn("3");
        when(computationEngine.computeOperation("Geometric Mean (8,2)")).thenReturn("4");
        when(computationEngine.computeOperation("Harmonic Mean (2,3)")).thenReturn("2.4");
        when(computationEngine.computeOperation("Root Mean Square (2,3)")).thenReturn("2.23");
        when(computationEngine.computeOperation("Contraharmonic Mean (2,3)")).thenThrow(new UnsupportedOperationException());


        assertNotNull("Geometric mean of the values 3,3 should not be null", computationService.computeMean("Geometric Mean", "3,3"));
        assertNotEquals("Geometric mean of the values 3,3 should not be 4", computationService.computeMean("Geometric Mean", "3,3"), "4");
        assertEquals("Geometric mean of the values 3,3 should be 3", computationService.computeMean("Geometric Mean", "3,3"), "3");

        assertNotNull("Geometric mean of the values 8,2 should not be null", computationService.computeMean("Geometric Mean", "8,2"));
        assertNotEquals("Geometric mean of the values 3,3 should not be 10", computationService.computeMean("Geometric Mean", "8,2"), "10");
        assertEquals("Geometric mean of the values 3,3 should be 4", computationService.computeMean("Geometric Mean", "8,2"), "4");

        assertNotNull("Harmonic mean of the values 2,3 should not be null", computationService.computeMean("Harmonic Mean", "2,3"));
        assertNotEquals("Harmonic mean of the values 2,3 should not be 4.2", computationService.computeMean("Harmonic Mean", "2,3"), "4.2");
        assertEquals("Harmonic mean of the values 2,3 should be 2.4", computationService.computeMean("Harmonic Mean", "2,3"), "2.4");

        assertNotNull("Root Mean Square of the values 2,3 should not be null", computationService.computeMean("Root Mean Square", "2,3"));
        assertNotEquals("Root Mean Square of the values 2,3 should not be 2.43", computationService.computeMean("Root Mean Square", "2,3"), "2.43");
        assertEquals("Root Mean Square of the values 2,3 should be 2.23", computationService.computeMean("Root Mean Square", "2,3"), "2.23");

        /* Contraharmonic mean implementation is not supported, hence it will throw an UnsupportedOperationException exception */
        computationService.computeMean("Contraharmonic Mean", "2,3");

    }

    /**
     * Test trigonometric function
     */
    @Test
    public void testTrigonometricFunction() {
        when(computationEngine.computeOperation("sin(0)")).thenReturn("0");
        when(computationEngine.computeOperation("sin(90)")).thenReturn("1");
        when(computationEngine.computeOperation("tan(0)")).thenReturn("0");
        when(computationEngine.computeOperation("tan(90)")).thenReturn("undefined");

        assertNotNull("The value of sine function of 0 degree should not be null", computationService.computeTrigonometricFunction("sin(0)"));
        assertNotEquals("The value of sine function of 0 degree should not be 1", computationService.computeTrigonometricFunction("sin(0)"), "1");
        assertNotEquals("The value of sine function of 0 degree should not be undefined", computationService.computeTrigonometricFunction("sin(0)"), "undefined");
        assertEquals("The value of sine function of 0 degree should be 0", computationService.computeTrigonometricFunction("sin(0)"), "0");

        assertNotNull("The value of sine function of 90 degree should not be null", computationService.computeTrigonometricFunction("sin(90)"));
        assertNotEquals("The value of sine function of 90 degree should not be 0", computationService.computeTrigonometricFunction("sin(90)"), "0");
        assertNotEquals("The value of sine function of 90 degree should not be undefined", computationService.computeTrigonometricFunction("sin(90)"), "undefined");
        assertEquals("The value of sine function of 90 degree should be 0", computationService.computeTrigonometricFunction("sin(90)"), "1");

        assertNotNull("The value of tangent function of 0 degree should not be null", computationService.computeTrigonometricFunction("tan(0)"));
        assertNotEquals("The value of tangent function of 0 degree should not be 1", computationService.computeTrigonometricFunction("tan(0)"), "1");
        assertNotEquals("The value of tangent function of 0 degree should not be undefined", computationService.computeTrigonometricFunction("tan(0)"), "undefined");
        assertEquals("The value of tangent function of 0 degree should be 0", computationService.computeTrigonometricFunction("tan(0)"), "0");

        assertNotNull("The value of tangent function of 90 degree should not be null", computationService.computeTrigonometricFunction("tan(90)"));
        assertNotEquals("The value of tangent function of 90 degree should not be 0", computationService.computeTrigonometricFunction("tan(90)"), "0");
        assertNotEquals("The value of tangent function of 90 degree should not be 1", computationService.computeTrigonometricFunction("tan(90)"), "1");
        assertEquals("The value of tangent function of 90 degree should be 0", computationService.computeTrigonometricFunction("tan(90)"), "undefined");
    }


    /**
     * Test Radian function by overriding implemented logic
     */
    @Test
    public void testRadianFunction() {

        when(computationEngine.computeRadian(Mockito.any()))
                .then(
                        invocation -> {
                            Object[] args = invocation.getArguments();
                            return Math.toRadians(Double.parseDouble(args[0].toString()));
                        }
                );

        assertNotNull("The radian of 10 degree should not be null", computationService.computeRadian(10d));
        assertNotEquals("The radian of 10 degree should not be 0.2", computationService.computeRadian(10d), 0.2);
        assertEquals("The radian of 10 degree should not be null", computationService.computeRadian(10d), Math.toRadians(10), 3);

    }
}
