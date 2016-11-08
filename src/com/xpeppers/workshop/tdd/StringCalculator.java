package com.xpeppers.workshop.tdd;

public class StringCalculator {

	private static final String DEFAULT_DELIMITERS_REGEX = "[\\n|,]";

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		String delimiter = DEFAULT_DELIMITERS_REGEX;
		String numbersSeparatedByDelimiter = delimiterAndNumbers;

		if (isNewDelimiterSpecified(delimiterAndNumbers)) {
			int endOfDelimiterIndex = delimiterAndNumbers.indexOf("\n");
			delimiter = delimiterAndNumbers.substring(2, endOfDelimiterIndex);
			numbersSeparatedByDelimiter = delimiterAndNumbers.substring(endOfDelimiterIndex + 1);
		}
		return sumAllSeparatedBy(delimiter, numbersSeparatedByDelimiter);
	}

	private int sumAllSeparatedBy(String delimiter, String numbersSeparatedByDelimiter) {
		String[] addendums = numbersSeparatedByDelimiter.split(delimiter);
		return sumAll(addendums);
	}

	private boolean isNewDelimiterSpecified(String numbersSeparatedByDelimiters) {
		return numbersSeparatedByDelimiters.startsWith("//");
	}

	private int sumAll(String[] addendums) {
		int sum = 0;
		for (String addendum : addendums) {
			sum += Integer.parseInt(addendum);
		}
		return sum;
	}

}
