package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StringParserTest {

	@Test
	public void whenInputIsEmpty() {
		StringParser parser = new StringParser("", "@");
		assertArrayEquals(new String[] { "" }, parser.extractNumbers());
	}

	@Test
	public void whenInputDoesntContainHeader() {
		StringParser parser = new StringParser("any string\nwith no header", "#");
		assertArrayEquals(new String[] { "any string\nwith no header" }, parser.extractNumbers());
	}

	@Test
	public void whenInputContainsHeader() {
		StringParser parser = new StringParser("//;\nany\nstring;any string", "$");
		assertArrayEquals(new String[] { "any\nstring", "any string" }, parser.extractNumbers());
	}

	@Test
	public void whenInputContainsDelimeterOfAnyLength() throws Exception {
		StringParser parser = new StringParser("//[\\*\\*\\*]\nany\\*\\*\\*string", "£");
		assertArrayEquals(new String[] { "any", "string" }, parser.extractNumbers());
	}

	@Test
	public void whenInputContainsMultipleDelimiters() throws Exception {
		StringParser parser = new StringParser("//[\\*][%]\nany\\*kind%string", "&");
		assertArrayEquals(new String[] { "any", "kind", "string" }, parser.extractNumbers());
	}
}
