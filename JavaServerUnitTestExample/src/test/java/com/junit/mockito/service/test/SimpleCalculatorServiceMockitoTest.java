package com.junit.mockito.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.computation.rest.service.SimpleCalculatorService;

/**
 * This class demonstrates use of Mockito framework to write tests for
 * {@link SimpleCalculatorService}.
 * 
 * @author schavan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleCalculatorServiceMockitoTest {

	/**
	 * Mock SimpleCalculatorService
	 */
	@Mock
	private SimpleCalculatorService simpleCalculatorService;

	/**
	 * Test square root of positive number
	 */
	@Test
	public void testSquareRootOfPositiveNumber() {
		when(simpleCalculatorService.sqrt(81)).thenReturn(9.0);

		assertEquals(9.0, simpleCalculatorService.sqrt(81), 0);
	}

	/**
	 * Test square root of a negative number
	 */
	@Test
	public void testSquareRootOfNegativeNumber() {
		when(simpleCalculatorService.sqrt(-9)).thenReturn(Double.NaN);
		assertEquals(Double.NaN, simpleCalculatorService.sqrt(-9), 0);
	}

	/**
	 * Test square root of a decimal number
	 */
	@Test
	public void testSquareRootOfDecimalNumber() {
		when(simpleCalculatorService.sqrt(0.16)).thenReturn(0.4);
		assertEquals(0.4, simpleCalculatorService.sqrt(0.16), 0);
	}

}
