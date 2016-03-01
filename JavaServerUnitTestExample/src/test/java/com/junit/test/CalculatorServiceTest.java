package com.junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.calculator.service.CalculatorService;
import com.calculator.service.CalculatorServiceImpl;

public class CalculatorServiceTest {
	private static CalculatorService calculator;

	@BeforeClass
	public static void initCalculator() {
		calculator = new CalculatorServiceImpl();
	}

	// @Before
	// public void beforeEachTest() {
	// System.out.println("This is executed before each Test");
	// }
	//
	// @After
	// public void afterEachTest() {
	// System.out.println("This is exceuted after each Test");
	// }

	/**
	 * Test add functionality for two positive values.
	 */
	@Test
	public void testAddForBothPositiveValues() {
		int result = calculator.add(3, 4);
		assertEquals(7, result);
	}

	/**
	 * Test add functionality for both negative values.
	 */
	@Test
	public void testAddBothNegativeValues() {
		int result = calculator.add(-3, -4);
		assertEquals(-7, result);
	}

	/**
	 * Test add functionality to add positive value to a smaller negative value.
	 */
	@Test
	public void testAddPositiveValueToSmallerNegativeValue() {
		int result = calculator.add(-3, 4);
		assertEquals(1, result);
	}

	/**
	 * Test add functionality to add a positive value to a negative value (the
	 * negative number value is greater then second positive value).
	 */
	@Test
	public void testAddPositiveValueToGreaterNegativeValue() {
		int result = calculator.add(-7, 4);
		assertEquals(-3, result);
	}

	/**
	 * Test add functionality to add zero value to positive value
	 */
	@Test
	public void testAddZeroToPostivieValue() {
		int result = calculator.add(4, 0);
		assertEquals(4, result);
	}

	/**
	 * Test add functionality to add zero value to negative value
	 */
	@Test
	public void testAddZeroToNegativeValue() {
		int result = calculator.add(-4, 0);
		assertEquals(-4, result);
	}

	/**
	 * Test add functionality to add positive value to a negative value (where
	 * the second operand numeric value is greater then first operand).
	 */
	@Test
	public void testAddGreaterNegativeValueToPositiveValue() {
		int result = calculator.add(3, -4);
		assertEquals(-1, result);
	}

	/**
	 * Test add functionality to add greater positive value to a smaller
	 * negative value
	 */
	@Test
	public void testAddForSecondSmallerNegativeValue() {
		int result = calculator.add(7, -4);
		assertEquals(3, result);
	}

	/**
	 * Test subtract functionality to subtract smaller positive value from
	 * greater positive value
	 */
	@Test
	public void testSubtractSmallerValueFromGreaterValue() {
		int result = calculator.subtract(5, 3);
		assertEquals(2, result);
	}

	/**
	 * Test subtract functionality to subtract greater positive value from
	 * smaller positive value
	 */
	@Test
	public void testSubtractGreaterValueFromSmallerValue() {
		int result = calculator.subtract(3, 5);
		assertEquals(-2, result);
	}

	/**
	 * Test subtract functionality to subtract zero from positive value
	 */
	@Test
	public void testSubtractZeroFromPositiveValue() {
		int result = calculator.subtract(4, 0);
		assertEquals(4, result);
	}

	/**
	 * Test subtract functionality to positive value from zero.
	 */
	@Test
	public void testSubtractPositiveValueFromZero() {
		int result = calculator.subtract(0, 4);
		assertEquals(-4, result);
	}

	/**
	 * Test subtract functionality to subtract zero from negative value.
	 */
	@Test
	public void testSubtractZeroFromNegativeValue() {
		int result = calculator.subtract(-4, 0);
		assertEquals(-4, result);
	}

	/**
	 * Test subtract functionality to subtract negative value from zero.
	 */
	@Test
	public void testSubtractNegativeValueFromZero() {
		int result = calculator.subtract(0, -4);
		assertEquals(4, result);
	}

	/**
	 * Test subtract functionality to subtract smaller negative value from
	 * greater negative value.
	 */
	@Test
	public void testSubtractSmallerNegativeValueFromGreaterNegativeValue() {
		int result = calculator.subtract(-3, -4);
		assertEquals(1, result);
	}

	/**
	 * Test subtract functionality to subtract greater negative value from
	 * smaller negative value.
	 */
	@Test
	public void testSubtractGreaterNegativeValueFromSmallerNegativeValue() {
		int result = calculator.subtract(-4, -3);
		assertEquals(-1, result);
	}

	/**
	 * Test subtract functionality to subtract positive value from negative
	 * value.
	 */
	@Test
	public void testSubtractPostiveValueFromNegativeValue() {
		int result = calculator.subtract(-3, 4);
		assertEquals(-7, result);
	}

	/**
	 * Test subtract functionality to subtract negative value from positive
	 * value.
	 */
	@Test
	public void testSubtractNegativeValueFromPositiveValue() {
		int result = calculator.subtract(3, -4);
		assertEquals(7, result);
	}

	/**
	 * Test multiply functionality for both positive values.
	 */
	@Test
	public void testMultiplyForBothPostiveValue() {
		int result = calculator.multiply(3, 4);
		assertEquals(12, result);
	}

	/**
	 * Test multiply functionality for both negative values.
	 */
	@Test
	public void testMultiplyForBothNegativeValue() {
		int result = calculator.multiply(-3, -4);
		assertEquals(12, result);
	}

	/**
	 * Test multiply functionality for both negative values.
	 */
	@Test
	public void testMultiplyForOneNegativeValue() {
		int result = calculator.multiply(-3, 4);
		assertEquals(-12, result);
	}

	/**
	 * Test multiply functionality for positive value with zero.
	 */
	@Test
	public void testMultiplyPositiveValueWithZero() {
		int result = calculator.multiply(0, 4);
		assertEquals(0, result);
	}

	/**
	 * Test multiply functionality for negative value with zero.
	 */
	@Test
	public void testMultiplyNegativeValueWithZero() {
		int result = calculator.multiply(0, -4);
		assertEquals(0, result);
	}

	/**
	 * Test division functionality for both positive values.
	 */
	@Test
	public void testDivison() {
		try {
			int result = calculator.divison(10, 2);
			assertEquals(5, result);
		} catch (Exception exc) {
			exc.printStackTrace(System.err);
		}
	}

	/**
	 * Test division functionality for negative dividend.
	 */
	@Test
	public void testDivisonForNegativeDividend() {
		try {
			int result = calculator.divison(-10, 2);
			assertEquals(-5, result);
		} catch (Exception exc) {
			exc.printStackTrace(System.err);
		}
	}

	/**
	 * Test division functionality with negative divisor.
	 */
	@Test
	public void testDivisonForNegativeDivisor() {
		try {
			int result = calculator.divison(10, -2);
			assertEquals(-5, result);
		} catch (Exception exc) {
			exc.printStackTrace(System.err);
		}
	}

	/**
	 * Test division functionality for prime dividend.
	 */
	@Test
	public void testDivisonForPrimeDividend() {
		try {
			int result = calculator.divison(7, 2);
			assertEquals(3, result);
		} catch (Exception exc) {
			exc.printStackTrace(System.err);
		}
	}

	/**
	 * Test division functionality for zero dividend.
	 */
	@Test
	public void testDivisonForZeroDividend() {
		try {
			int result = calculator.divison(0, 2);
			assertEquals(0, result);
		} catch (Exception exc) {
			exc.printStackTrace(System.err);
		}
	}

	/**
	 * Test division functionality with zero divisor and handle arithmetic
	 * exception. As anything divided by zero is infinite.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivisionException() {
		calculator.divison(10, 0);
	}

	// @Ignore
	// @Test
	// public void testSubtract() {
	// int result = 10 - 3;
	// assertTrue(result == 9);
	// }

}
