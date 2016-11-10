package com.xpeppers.workshop.tdd;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	private static final String DEFAULT_DELIMITERS_REGEX = "[\\n|,]";

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		HeaderParser headerParser = new HeaderParser(delimiterAndNumbers, DEFAULT_DELIMITERS_REGEX);
		String[] addendums = headerParser.parse();
		throwsExceptionIfAtLeastOneNegative(addendums);
		return sumAll(addendums);
	}

	private int sumAll(String[] addendums) {
		return Stream.of(addendums).mapToInt(addendum -> Integer.parseInt(addendum)).sum();
	}

	private void throwsExceptionIfAtLeastOneNegative(String[] addendums) {
		String negatives = Stream.of(addendums)
				.filter(addendum -> Integer.parseInt(addendum) < 0)
				.collect(Collectors.joining(", "));

		if (!negatives.isEmpty())
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
	}
}
