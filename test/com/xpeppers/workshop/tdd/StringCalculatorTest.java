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
		int result = calculator.add("");
		Assert.assertEquals(0, result);
	}

	@Test
	public void forStringWithOneNumberReturnsNumberItself() {
		int result = calculator.add("1");
		Assert.assertEquals(1, result);
	}

}
