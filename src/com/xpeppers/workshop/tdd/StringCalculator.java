package com.xpeppers.workshop.tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private static final String DEFAULT_DELIMITERS_REGEX = "[\\n|,]";

	public int add(String delimiterAndNumbers) {
		if (delimiterAndNumbers.isEmpty())
			return 0;

		HeaderParser headerParser = new HeaderParser(delimiterAndNumbers, DEFAULT_DELIMITERS_REGEX);
		String[] addendums = headerParser.allButHeader().split(headerParser.delimiter());
		throwsExceptionIfAtLeastOneNegative(addendums);
		return sumAll(addendums);
	}

	private int sumAll(String[] addendums) {
		int sum = 0;
		for (String addendum : addendums) {
			sum += Integer.parseInt(addendum);
		}
		return sum;
	}

	private void throwsExceptionIfAtLeastOneNegative(String[] addendums) {
		List<String> negatives = new ArrayList<>();
		for (String addendum : addendums) {
			if (Integer.parseInt(addendum) < 0)
				negatives.add(addendum);
		}
		if (!negatives.isEmpty())
			throw new IllegalArgumentException("negatives not allowed: " + String.join(", ", negatives));
	}
}
