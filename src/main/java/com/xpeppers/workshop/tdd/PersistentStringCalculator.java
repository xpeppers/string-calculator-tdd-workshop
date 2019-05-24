package com.xpeppers.workshop.tdd;

public class PersistentStringCalculator {

	private StringCalculator calculator;
	private Repository repository;

	public PersistentStringCalculator(StringCalculator calculator, Repository repository) {
		this.calculator = calculator;
		this.repository = repository;
	}

	public void add(String delimiterAndNumbers) throws Exception {
		int result = calculator.add(delimiterAndNumbers);
		repository.save(delimiterAndNumbers, result);
	}

}
