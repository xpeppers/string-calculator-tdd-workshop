package com.xpeppers.workshop.tdd;

import java.util.regex.Pattern;

public class HeaderParser {

	final private String delimiterAndNumbers;
	final private String defaultDelimiter;
	final private boolean isNewDelimiterSpecified;
	final private int endOfDelimiterIndex;

	public HeaderParser(String delimiterAndNumbers, String defaultDelimiter) {
		this.delimiterAndNumbers = delimiterAndNumbers;
		this.defaultDelimiter = defaultDelimiter;

		isNewDelimiterSpecified = delimiterAndNumbers.startsWith("//");
		endOfDelimiterIndex = delimiterAndNumbers.indexOf("\n");
	}

	public String[] parse() {
		return allButHeader().split(delimiter());
	}

	private String delimiter() {
		if (!isNewDelimiterSpecified)
			return defaultDelimiter;

		String delimiter = delimiterAndNumbers.substring(2, endOfDelimiterIndex);
		delimiter = delimiter.replaceAll("\\[|\\]", "");
		return Pattern.quote(delimiter);
	}

	private String allButHeader() {
		if (!isNewDelimiterSpecified)
			return delimiterAndNumbers;

		return delimiterAndNumbers.substring(endOfDelimiterIndex + 1);
	}

}
