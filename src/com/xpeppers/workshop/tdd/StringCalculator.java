package com.xpeppers.workshop.tdd;

public class StringCalculator {

	public int add(String commaSeparatedNumbers) {
		if (commaSeparatedNumbers.isEmpty())
			return 0;

		if (!commaSeparatedNumbers.contains(","))
			return Integer.parseInt(commaSeparatedNumbers);

		String[] addendums = commaSeparatedNumbers.split(",");
		return Integer.parseInt(addendums[0]) + Integer.parseInt(addendums[1]);
	}

}
