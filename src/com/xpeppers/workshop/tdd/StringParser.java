package com.xpeppers.workshop.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {

	final private String delimiterAndNumbers;
	final private List<String> defaultDelimiters;
	final private boolean isCustomDelimiterSpecified;
	final private int endOfDelimiterIndex;

	public StringParser(String delimiterAndNumbers, String... defaultDelimiters) {
		this.delimiterAndNumbers = delimiterAndNumbers;
		this.defaultDelimiters = Arrays.asList(defaultDelimiters);

		isCustomDelimiterSpecified = delimiterAndNumbers.startsWith("//");
		endOfDelimiterIndex = delimiterAndNumbers.indexOf("\n");
	}

	public String[] extractNumbers() {
		return allButHeader().split(toOrRegEx(delimiters()));
	}

	private String toOrRegEx(List<String> delimiters) {
		return String.join("|", delimiters);
	}

	private List<String> delimiters() {
		List<String> delimitersToUse = defaultDelimiters;
		if (isCustomDelimiterSpecified)
			delimitersToUse = detectMulptipleCustomDelimiters();

		return delimitersToUse;
	}

	private List<String> detectMulptipleCustomDelimiters() {
		String delimiters = delimiterAndNumbers.substring(2, endOfDelimiterIndex);
		List<String> splittedDelimiters = Arrays.asList(delimiters.split(Pattern.quote("]") + Pattern.quote("[")));
		splittedDelimiters.replaceAll(d -> d.replaceAll(Pattern.quote("[") + "|" + Pattern.quote("]"), ""));
		splittedDelimiters.replaceAll(d -> Pattern.quote(d));
		return splittedDelimiters;
	}

	private String allButHeader() {
		if (!isCustomDelimiterSpecified)
			return delimiterAndNumbers;

		return delimiterAndNumbers.substring(endOfDelimiterIndex + 1);
	}

}
