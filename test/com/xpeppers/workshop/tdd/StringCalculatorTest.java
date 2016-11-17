package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Rule
	public ExpectedException exception = ExpectedException.none();

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

	@Test
	public void allowNewLineAsDelimiter() throws Exception {
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(6, calculator.add("1\n2\n3"));
	}

	@Test
	public void allowChangingDelimiter() throws Exception {
		assertEquals(3, calculator.add("//;\n1;2"));
	}

	@Test
	public void negativeNumberThrowsException() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("negatives not allowed: -3");

		calculator.add("0,1,2,-3,4,5");
	}

	@Test
	public void manyNegativeNumbersHasToBeShownInExceptionMessage() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("negatives not allowed: -1, -3, -4");

		calculator.add("0,-1,2,-3,-4,5");
	}

	@Test
	public void numbersBiggerThan1000ShouldBeIgnored() throws Exception {
		assertEquals(2, calculator.add("1000,2"));
	}

	@Test
	public void delimitersCanBeOfAnyLength() throws Exception {
		assertEquals(6, calculator.add("//[\\*\\*\\*]\n1\\*\\*\\*2\\*\\*\\*3"));
		assertEquals(6, calculator.add("//[del]\n1del2del3"));
	}

	@Test
	public void allowMultipleDelimiters() throws Exception {
		assertEquals(6, calculator.add("//[\\*][%]\n1\\*2%3"));
		assertEquals(10, calculator.add("//[d][c][e]\n1c2d3e4"));
	}

	@Test
	public void allowMultipleDelimiterswithLengthLongerThanOneChar() throws Exception {
		assertEquals(6, calculator.add("//[\\*\\*\\*][%]\n1\\*\\*\\*2%3"));
		assertEquals(6, calculator.add("//[del][$$]\n1$$2del3"));
	}
}
