package com.xpeppers.workshop.tdd;

public class StringCalculator {

	public int add(String commaSeparatedNumbers) {
		if (commaSeparatedNumbers.isEmpty())
			return 0;

		String[] addendums = commaSeparatedNumbers.split(",");
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
