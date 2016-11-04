package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Before
	public void setUp() {
		calculator = new StringCalculator();
	}

	@Test
	public void forEmptyStringReturns0() {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void forStringWithOneNumberReturnsNumberItself() {
		assertEquals(0, calculator.add("0"));
		assertEquals(1, calculator.add("1"));
		assertEquals(2, calculator.add("2"));
	}

	@Test
	public void forTwoNumbersStringReturnsSumOfNumbers() {
		assertEquals(3, calculator.add("1,2"));
		assertEquals(5, calculator.add("3,2"));
		assertEquals(7, calculator.add("0,7"));
	}
	
	@Test
	public void sumManyNumbers() throws Exception {
		assertEquals(15, calculator.add("1,2,3,4,5"));
	}

}
