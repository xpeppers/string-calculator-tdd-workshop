package com.xpeppers.workshop.tdd;

public class StringCalculator {

	private static final String SEPARATOR_REGEX = "[\\n|,]";

	public int add(String commaOrNewLineSeparatedNumbers) {
		if (commaOrNewLineSeparatedNumbers.isEmpty())
			return 0;

		String[] addendums = commaOrNewLineSeparatedNumbers.split(SEPARATOR_REGEX);
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
