package com.junit.mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.calculator.component.ComputationEngine;
import com.calculator.component.exception.ResultNotFoundException;
import com.calculator.service.ComputationService;
import com.calculator.service.ComputationServiceImpl;

public class ComputationServiceTest {

    private static ComputationEngine computationEngine;

    private static ComputationService computationService;

    private static AtomicLong executed = new AtomicLong(0);

    @BeforeClass
    public static void setupMocks() {
        // computationEngine = new ComputationEngine("Q6VYUE-95GGAX4U8Q", "plaintext");
        computationEngine = mock(ComputationEngine.class);
        setupMockMethods();
        computationService = new ComputationServiceImpl(computationEngine);
    }

    @Test
    public void testBasicAirthmeticOperation() {
        executed.getAndIncrement();
        assertEquals(computationService.basicAirthmeticOperation("2*2"), "4");
        assertEquals(computationService.basicAirthmeticOperation("2+22"), "24");
    }

    @Test
    public void testConvertDecimalToBinary() {
        executed.getAndIncrement();
        assertEquals(computationService.convertDecimalToBinary("219 to binary"), "11011011_2");
        assertEquals(computationService.convertDecimalToBinary("4242 to binary"), "1000010010010_2");
    }

    @Test
    public void testConvertUnitAndMeasure() {
        executed.getAndIncrement();
        assertEquals(computationService.convertUnitAndMeasure("120 kilometers to meters"), "120000 meters");
        assertEquals(computationService.convertUnitAndMeasure("160 kilometers to miles"), "99.42 miles");
    }

    @Test(expected = ResultNotFoundException.class)
    public void testResultNotFoundException() {
        executed.getAndIncrement();
        computationService.basicAirthmeticOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(");
    }

    @Test
    public void testIncompatibleConversion() {
        executed.getAndIncrement();
        assertEquals(computationService.convertUnitAndMeasure("convert 1024 megabytes to miles"), " MB  (megabytes) and  miles are not compatible.");
    }

    @AfterClass
    public static void printDetails() {
        System.out.println("Executed " + executed.longValue() + " test cases.");
    }

    private static void setupMockMethods() {
        when(computationEngine.computeOperation("2*2")).thenReturn("4");
        when(computationEngine.computeOperation("2+22")).thenReturn("24");

        when(computationEngine.computeOperation("219 to binary")).thenReturn("11011011_2");
        when(computationEngine.computeOperation("4242 to binary")).thenReturn("1000010010010_2");

        when(computationEngine.computeOperation("120 kilometers to meters")).thenReturn("120000 meters");
        when(computationEngine.computeOperation("160 kilometers to miles")).thenReturn("99.42 miles");

        when(computationEngine.computeOperation("!@#$%^&*()!@#$%^&*()!@#$%^&*(")).thenThrow(new ResultNotFoundException("No result found for given query"));
        when(computationEngine.computeOperation("convert 1024 megabytes to miles")).thenReturn(" MB  (megabytes) and  miles are not compatible.");
    }
}
