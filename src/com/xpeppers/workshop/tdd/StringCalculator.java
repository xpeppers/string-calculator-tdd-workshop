package com.xpeppers.workshop.tdd;

public class StringCalculator {

	public int add(String number) {
		if (number.isEmpty())
			return 0;

		return Integer.parseInt(number);
	}

}
