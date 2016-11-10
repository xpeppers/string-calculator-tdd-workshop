package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeaderParserTest {

	@Test
	public void whenInputIsEmpty() {
		HeaderParser parser = new HeaderParser("", "@");
		assertArrayEquals(parser.parse(), new String[] { "" });
	}

	@Test
	public void whenInputDoesntContainHeader() {
		HeaderParser parser = new HeaderParser("any string\nwith no header", "#");
		assertArrayEquals(parser.parse(), new String[] { "any string\nwith no header" });
	}

	@Test
	public void whenInputContainsHeader() {
		HeaderParser parser = new HeaderParser("//;\nany\nstring", "$");
		assertArrayEquals(parser.parse(), new String[] { "any\nstring" });
	}
}
