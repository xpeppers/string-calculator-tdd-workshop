package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeaderParserTest {

	@Test
	public void whenInputIsEmpty() {
		HeaderParser parser = new HeaderParser("", "@");
		assertArrayEquals(new String[] { "" }, parser.parse());
	}

	@Test
	public void whenInputDoesntContainHeader() {
		HeaderParser parser = new HeaderParser("any string\nwith no header", "#");
		assertArrayEquals(new String[] { "any string\nwith no header" }, parser.parse());
	}

	@Test
	public void whenInputContainsHeader() {
		HeaderParser parser = new HeaderParser("//;\nany\nstring;any string", "$");
		assertArrayEquals(new String[] { "any\nstring", "any string" }, parser.parse());
	}

	@Test
	public void whenInputContainsDelimeterOfAnyLength() throws Exception {
		HeaderParser parser = new HeaderParser("//[\\*\\*\\*]\nany\\*\\*\\*string", "£");
		assertArrayEquals(new String[] { "any", "string" }, parser.parse());
	}
}
