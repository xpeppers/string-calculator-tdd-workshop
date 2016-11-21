package com.xpeppers.workshop.tdd;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		HeaderParser headerParser = new HeaderParser(delimiterAndNumbers, "\n", ",");
		String[] addendums = headerParser.parse();
		throwsExceptionIfAtLeastOneNegative(addendums);
		return sumAll(addendums);
	}

	private int sumAll(String[] addendums) {
		return Stream.of(addendums)
				.mapToInt(addendum -> Integer.parseInt(addendum))
				.filter(addendum -> addendum < 1000).sum();
	}

	private void throwsExceptionIfAtLeastOneNegative(String[] addendums) {
		String negatives = Stream.of(addendums)
				.filter(addendum -> Integer.parseInt(addendum) < 0)
				.collect(Collectors.joining(", "));

		if (!negatives.isEmpty())
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
	}
}
