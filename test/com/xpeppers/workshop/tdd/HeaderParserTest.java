package com.xpeppers.workshop.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderParserTest {

	@Test
	public void whenInputIsEmpty() {
		HeaderParser parser = new HeaderParser("", "@");
		assertEquals("@", parser.delimiter());
		assertEquals("", parser.allButHeader());
	}

	@Test
	public void whenInputDoesntContainHeader() {
		HeaderParser parser = new HeaderParser("any string\nwith no header", "#");
		assertEquals("#", parser.delimiter());
		assertEquals("any string\nwith no header", parser.allButHeader());
	}

	@Test
	public void whenInputContainsHeader() {
		HeaderParser parser = new HeaderParser("//;\nany\nstring", "$");
		assertEquals(";", parser.delimiter());
		assertEquals("any\nstring", parser.allButHeader());
	}
}
