package com.xpeppers.workshop.tdd;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		StringParser parser = new StringParser(delimiterAndNumbers, ",", "\n");
		String[] addendums = parser.extractNumbers();
		throwsExceptionIfAtLeastOneNegative(addendums);
		return sumAllLessThan1000(addendums);
	}

	private void throwsExceptionIfAtLeastOneNegative(String[] addendums) {
		String negatives = Stream.of(addendums)
				.filter(addendum -> Integer.parseInt(addendum) < 0)
				.collect(Collectors.joining(", "));

		if (!negatives.isEmpty())
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
	}

	private int sumAllLessThan1000(String[] addendums) {
		return Stream.of(addendums)
				.mapToInt(addendum -> Integer.parseInt(addendum))
				.filter(addendum -> addendum < 1000)
				.sum();
	}
}
