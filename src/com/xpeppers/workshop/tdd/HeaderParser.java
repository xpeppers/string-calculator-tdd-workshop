package com.xpeppers.workshop.tdd;

public class HeaderParser {

	private String delimiterAndNumbers;
	private int endOfDelimiterIndex;

	public HeaderParser(String delimiterAndNumbers) {
		this.delimiterAndNumbers = delimiterAndNumbers;
		endOfDelimiterIndex = delimiterAndNumbers.indexOf("\n");
	}

	public boolean isNewDelimiterSpecified() {
		return delimiterAndNumbers.startsWith("//");
	}

	public String delimiter() {
		return delimiterAndNumbers.substring(2, endOfDelimiterIndex);
	}

	public String allButHeader() {
		return delimiterAndNumbers.substring(endOfDelimiterIndex + 1);
	}

}
