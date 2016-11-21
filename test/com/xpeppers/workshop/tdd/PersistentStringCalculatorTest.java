package com.xpeppers.workshop.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersistentStringCalculatorTest {

	@InjectMocks
	private PersistentStringCalculator persistentStringCalculator;

	@Mock
	private StringCalculator stringCalculator;

	@Mock
	private Repository repository;

	@Test
	public void savesStringCalculatorInputAndOutput() {
		String delimiterAndNumbers = "anyInput";
		int simulatedResult = 42;
		Mockito.when(stringCalculator.add(delimiterAndNumbers)).thenReturn(simulatedResult);

		persistentStringCalculator.add(delimiterAndNumbers);

		Mockito.verify(repository).save(delimiterAndNumbers, simulatedResult);
		Mockito.verify(stringCalculator).add(delimiterAndNumbers);
	}

}
