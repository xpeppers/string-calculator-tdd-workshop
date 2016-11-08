package com.xpeppers.workshop.tdd;

public class StringCalculator {

	private static final String DEFAULT_DELIMITERS_REGEX = "[\\n|,]";

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		HeaderParser headerParser = new HeaderParser(delimiterAndNumbers, DEFAULT_DELIMITERS_REGEX);
		return sumAllSeparatedBy(headerParser.delimiter(), headerParser.allButHeader());
	}

	private int sumAllSeparatedBy(String delimiter, String numbersSeparatedByDelimiter) {
		String[] addendums = numbersSeparatedByDelimiter.split(delimiter);
		return sumAll(addendums);
	}

	private int sumAll(String[] addendums) {
		int sum = 0;
		for (String addendum : addendums) {
			sum += Integer.parseInt(addendum);
		}
		return sum;
	}

}
