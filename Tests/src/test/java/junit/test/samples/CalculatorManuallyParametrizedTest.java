package junit.test.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CalculatorManuallyParametrizedTest {

	@Test
	public void addNumbersPositiveNumbers(){
		assertAddingNumbers(1, 2, 3);
		assertAddingNumbers(2, 5, 7);
	}

	@Test
	public void subtractNumbersPositiveNumbers(){
		assertSubtractingNumbers(10, 2, 8);
		assertSubtractingNumbers(6, 4, 2);
		assertSubtractingNumbers(5, 1, 4);
	}
	private void assertAddingNumbers(
			int firstNumber,
			int secondNumber,
			int expectedResult
	){
		assertEquals(expectedResult,
				firstNumber + secondNumber);
	}

	private void assertSubtractingNumbers(int first, int second, int expected){
		assertEquals(expected, first - second);
	}
}
