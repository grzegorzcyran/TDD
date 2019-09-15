package tdd.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void setup(){
		stringCalculator = new StringCalculator();
	}

	//Test1 1
	//Jeśli przekażemy "" to ma nam zwrócić 0
	@Test
	public void shouldReturnZeroWhenEmptyString() {
		int result = stringCalculator.add("");

		assertEquals(0, result, "Should return 0 when empty string passed");
	}

	/**
	 * Test2
	 * Jeśli przekażemy "1" to ma nam zwrócić 1
	 */
	@Test
	public void shouldReturnOneWhenOnePassed(){
		int result = stringCalculator.add("1");

		assertEquals(1, result, "Should return 1 when 1 passed");
	}

	/**
	 * Test 3
	 * Jeśli przekażemy "1,2" to ma zwrócić sumę
	 */
	@Test
	public void shouldReturnSumWhenTwoNumbersPassed(){
		int result = stringCalculator.add("1,2");

		assertEquals(3, result, "Should return 3 when 1,2 passed");

	}

	/**
	 * Test 4
	 * Jeśli przekażemy "1,2,3,4" to ma zwrócić sumę
	 */
	@Test
	public void shouldReturnSumWhenMultipleNumbersPassed(){
		int result = stringCalculator.add("1,2,3,4");

		assertEquals(10, result, "Should return 10 when 1,2,3,4 passed");

	}

	/**
	 * Test 5
	 * Jezeli przekazemy "1,2,3\n4" to ma zwrócić sumę
	 */
	@Test
	public void shouldReturnSumWhenMultipleNumbersPassedAndNewLineOccurs() {
		int result = stringCalculator.add("1,2,3\n4");

		assertEquals(10, result, "Should return 10 when 1,2,3\n4 passed");
	}

	/**
	 * Test 6
	 * Różne separatory
	 * Jezeli przekazemy "//;\n1;2;3;4" to ma zwrócić sumę
	 */
	@Test
	public void shouldReturnSumWhenMultipleNumbersPassedAndCustomSeparator() {
		String numbers = "//;\n1;2;3;4";

		int result = stringCalculator.add(numbers);

		assertEquals(10, result, "Should return 10 when numbers passed");
	}

	/**
	 * Test 7
	 * Różne separatory
	 * Jezeli przekazemy "//;\n1;2;3\n4" to ma zwrócić sumę
	 */
	@Test
	public void shouldReturnSumWhenMultipleNumbersPassedAndCustomSeparatorAndNewLine() {
		String numbers = "//;\n1;2;3\n4";

		int result = stringCalculator.add(numbers);

		assertEquals(10, result, "Should return 10 when numbers passed");
	}



}
