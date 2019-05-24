package com.xpeppers.workshop.tdd;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void savesStringCalculatorInputAndOutput() throws Exception {
		String delimiterAndNumbers = "anyInput";
		int simulatedResult = 42;
		when(stringCalculator.add(delimiterAndNumbers)).thenReturn(simulatedResult);

		persistentStringCalculator.add(delimiterAndNumbers);

		verify(repository).save(delimiterAndNumbers, simulatedResult);
		verify(stringCalculator).add(delimiterAndNumbers);
	}

	@Test
	public void hideException() throws Exception {
		String expectedMessage = "simulated exception on save";
		exception.expect(Exception.class);
		exception.expectMessage(expectedMessage);

		Mockito.doThrow(new Exception(expectedMessage)).when(repository).save(Mockito.anyString(), Mockito.anyInt());

		persistentStringCalculator.add("delimiterAndNumbers");
	}

}
