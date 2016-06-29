package com.junit.mockito.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.computation.rest.service.SimpleCalculatorService;
import com.computation.rest.service.impl.SimpleCalculatorServiceImpl;

public class SimpleCalculatorServiceTest {

	private static final float FLOAT_VALUE_0 = 0.0f;

	private static final float FLOAT_VALUE_1 = 1.0f;
	private static final float NEG_FLOAT_VALUE_1 = -1.0f;

	private static final float FLOAT_VALUE_2 = 2.0f;
	private static final float NEG_FLOAT_VALUE_2 = -2.0f;

	private static final float FLOAT_VALUE_3 = 3.0f;
	private static final float FLOAT_VALUE_3_POINT_5 = 3.5f;
	private static final float NEG_FLOAT_VALUE_3 = -3.0f;

	private static final float FLOAT_VALUE_4 = 4.0f;
	private static final float NEG_FLOAT_VALUE_4 = -4.0f;

	private static final float FLOAT_VALUE_5 = 5.0f;
	private static final float NEG_FLOAT_VALUE_5 = -5.0f;

	private static final float FLOAT_VALUE_7 = 7.0f;
	private static final float NEG_FLOAT_VALUE_7 = -7.0f;

	private static final float FLOAT_VALUE_10 = 10.0f;
	private static final float NEG_FLOAT_VALUE_10 = -10.0f;
	
	private static final float FLOAT_VALUE_12 = 12.0f;
	private static final float NEG_FLOAT_VALUE_12 = -12.0f;
	
	private static SimpleCalculatorService calculator;

	@BeforeClass
	public static void initCalculator() {
		calculator = new SimpleCalculatorServiceImpl();
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
		float result = calculator.add(FLOAT_VALUE_3, FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_7, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality for both negative values.
	 */
	@Test
	public void testAddBothNegativeValues() {
		float result = calculator.add(NEG_FLOAT_VALUE_3, NEG_FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_7, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add positive value to a smaller negative value.
	 */
	@Test
	public void testAddPositiveValueToSmallerNegativeValue() {
		float result = calculator.add(NEG_FLOAT_VALUE_3, FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_1, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add a positive value to a negative value (the
	 * negative number value is greater then second positive value).
	 */
	@Test
	public void testAddPositiveValueToGreaterNegativeValue() {
		float result = calculator.add(NEG_FLOAT_VALUE_7, FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_3, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add zero value to positive value
	 */
	@Test
	public void testAddZeroToPostivieValue() {
		float result = calculator.add(FLOAT_VALUE_4, FLOAT_VALUE_0);
		assertEquals(FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add zero value to negative value
	 */
	@Test
	public void testAddZeroToNegativeValue() {
		float result = calculator.add(NEG_FLOAT_VALUE_4, FLOAT_VALUE_0);
		assertEquals(NEG_FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add positive value to a negative value (where
	 * the second operand numeric value is greater then first operand).
	 */
	@Test
	public void testAddGreaterNegativeValueToPositiveValue() {
		float result = calculator.add(FLOAT_VALUE_3, NEG_FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_1, result, FLOAT_VALUE_0);
	}

	/**
	 * Test add functionality to add greater positive value to a smaller
	 * negative value
	 */
	@Test
	public void testAddForSecondSmallerNegativeValue() {
		float result = calculator.add(FLOAT_VALUE_7, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_3, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract smaller positive value from
	 * greater positive value
	 */
	@Test
	public void testSubtractSmallerValueFromGreaterValue() {
		float result = calculator.subtract(FLOAT_VALUE_5, FLOAT_VALUE_3);
		assertEquals(FLOAT_VALUE_2, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract greater positive value from
	 * smaller positive value
	 */
	@Test
	public void testSubtractGreaterValueFromSmallerValue() {
		float result = calculator.subtract(FLOAT_VALUE_3, FLOAT_VALUE_5);
		assertEquals(NEG_FLOAT_VALUE_2, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract zero from positive value
	 */
	@Test
	public void testSubtractZeroFromPositiveValue() {
		float result = calculator.subtract(FLOAT_VALUE_4, FLOAT_VALUE_0);
		assertEquals(FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to positive value from zero.
	 */
	@Test
	public void testSubtractPositiveValueFromZero() {
		float result = calculator.subtract(FLOAT_VALUE_0, FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract zero from negative value.
	 */
	@Test
	public void testSubtractZeroFromNegativeValue() {
		float result = calculator.subtract(NEG_FLOAT_VALUE_4, FLOAT_VALUE_0);
		assertEquals(NEG_FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract negative value from zero.
	 */
	@Test
	public void testSubtractNegativeValueFromZero() {
		float result = calculator.subtract(FLOAT_VALUE_0, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_4, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract smaller negative value from
	 * greater negative value.
	 */
	@Test
	public void testSubtractSmallerNegativeValueFromGreaterNegativeValue() {
		float result = calculator.subtract(NEG_FLOAT_VALUE_3, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_1, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract greater negative value from
	 * smaller negative value.
	 */
	@Test
	public void testSubtractGreaterNegativeValueFromSmallerNegativeValue() {
		float result = calculator.subtract(NEG_FLOAT_VALUE_4, NEG_FLOAT_VALUE_3);
		assertEquals(NEG_FLOAT_VALUE_1, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract positive value from negative
	 * value.
	 */
	@Test
	public void testSubtractPostiveValueFromNegativeValue() {
		float result = calculator.subtract(NEG_FLOAT_VALUE_3, FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_7, result, FLOAT_VALUE_0);
	}

	/**
	 * Test subtract functionality to subtract negative value from positive
	 * value.
	 */
	@Test
	public void testSubtractNegativeValueFromPositiveValue() {
		float result = calculator.subtract(FLOAT_VALUE_3, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_7, result, FLOAT_VALUE_0);
	}

	/**
	 * Test multiply functionality for both positive values.
	 */
	@Test
	public void testMultiplyForBothPostiveValue() {
		float result = calculator.multiply(FLOAT_VALUE_3, FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_12, result, FLOAT_VALUE_0);
	}

	/**
	 * Test multiply functionality for both negative values.
	 */
	@Test
	public void testMultiplyForBothNegativeValue() {
		float result = calculator.multiply(NEG_FLOAT_VALUE_3, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_12, result, FLOAT_VALUE_0);
	}

	/**
	 * Test multiply functionality for both negative values.
	 */
	@Test
	public void testMultiplyForOneNegativeValue() {
		float result = calculator.multiply(NEG_FLOAT_VALUE_3, FLOAT_VALUE_4);
		assertEquals(NEG_FLOAT_VALUE_12, result, FLOAT_VALUE_0);
	}

	/**
	 * Test multiply functionality for positive value with zero.
	 */
	@Test
	public void testMultiplyPositiveValueWithZero() {
		float result = calculator.multiply(FLOAT_VALUE_0, FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_0, result, FLOAT_VALUE_0);
	}

	/**
	 * Test multiply functionality for negative value with zero.
	 */
	@Test
	public void testMultiplyNegativeValueWithZero() {
		float result = calculator.multiply(FLOAT_VALUE_0, NEG_FLOAT_VALUE_4);
		assertEquals(FLOAT_VALUE_0, result, FLOAT_VALUE_0);
	}

	/**
	 * Test division functionality for both positive values.
	 */
	@Test
	public void testDivison() {
		try {
			float result = calculator.divison(FLOAT_VALUE_10, FLOAT_VALUE_2);
			assertEquals(FLOAT_VALUE_5, result, FLOAT_VALUE_0);
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
			float result = calculator.divison(NEG_FLOAT_VALUE_10, FLOAT_VALUE_2);
			assertEquals(NEG_FLOAT_VALUE_5, result, FLOAT_VALUE_0);
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
			float result = calculator.divison(FLOAT_VALUE_10, NEG_FLOAT_VALUE_2);
			assertEquals(NEG_FLOAT_VALUE_5, result, FLOAT_VALUE_0);
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
			float result = calculator.divison(FLOAT_VALUE_7, FLOAT_VALUE_2);
			assertEquals(FLOAT_VALUE_3_POINT_5, result, FLOAT_VALUE_0);
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
			float result = calculator.divison(FLOAT_VALUE_0, FLOAT_VALUE_2);
			assertEquals(FLOAT_VALUE_0, result, FLOAT_VALUE_0);
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
		calculator.divison(FLOAT_VALUE_10, FLOAT_VALUE_0);
	}

	// @Ignore
	// @Test
	// public void testSubtract() {
	// float result = 10 - 3;
	// assertTrue(result == 9);
	// }

}
