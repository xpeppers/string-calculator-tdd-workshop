package com.xpeppers.workshop.tdd;

import org.junit.Assert;
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
		Assert.assertEquals(0, calculator.add(""));
	}

	@Test
	public void forStringWithOneNumberReturnsNumberItself() {
		Assert.assertEquals(0, calculator.add("0"));
		Assert.assertEquals(1, calculator.add("1"));
		Assert.assertEquals(2, calculator.add("2"));
	}

	@Test
	public void forTwoNumbersStringReturnsSumOfNumbers() {
		Assert.assertEquals(3, calculator.add("1,2"));
		Assert.assertEquals(5, calculator.add("3,2"));
		Assert.assertEquals(7, calculator.add("0,7"));
	}

}
