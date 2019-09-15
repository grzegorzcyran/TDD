package tdd.sample;

import static org.junit.Assert.fail;
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

	/**
	 * Test 8
	 * Liczba ujemna
	 * Jezeli przekazemy "-1" to ma zwrócić komunikat:
	 * "negatives not allowed" i wyświetlić tą liczbę ujemną
	 */
	@Test
	public void shouldReturnExceptionWhenNegativePassed(){
		try {
			stringCalculator.add("-1");
			fail("Exception expected here");
		} catch (IllegalArgumentException ex) {
			assertEquals("negatives not allowed: -1", ex.getMessage());
		}
	}

	/**
	 * Test 9
	 * Liczby ujemna
	 * Jezeli przekazemy "1,-2,3,-4,5" to ma zwrócić komunikat:
	 * "negatives not allowed" i wyświetlić wszystkie liczby ujemne
	 */
	@Test
	public void shouldReturnExceptionWhenMultipleNegativesPassed() {
		try {
			stringCalculator.add("1,-2,3,-4,5");
			fail("Exception expected here");
		} catch (IllegalArgumentException ex) {
			assertEquals("negatives not allowed: -2, -4", ex.getMessage());
		}
	}

	/**
	 * Test 10
	 * Liczby większe lub równe 1000 powinny być ignorowane
	 * "1,2,1000,3" =6
	 */
	@Test
	public void shouldIgnoreNumbersGreaterOrEqualToOneThousand(){
		String numbers = "1,2,1000,3";

		int result = stringCalculator.add(numbers);

		assertEquals(6, result, "Should return 6 and ignore values greater or equal to 1000");
	}

	/**
	 * Test 11
	 * Delimitery większe niż jeden znak, np ** albo ;;
	 * "//;;\n1;;2;;3;;4"
	 */
	@Test
	public void shouldAllowMulticharDelimiters(){
		String numbers = "//;;\n1;;2;;3;;4";

		int result = stringCalculator.add(numbers);

		assertEquals(10, result, "Should return 10 and work with multichar delimiters");
	}

	/**
	 * Test 12
	 * should allow different delimiters
	 * "//;,\n1,2;3,4"
	 */
	@Test
	public void shouldAllowDifferentDelimiters(){
		String numbers = "//;,\n1,2;3,4";

		int result = stringCalculator.add(numbers);

		assertEquals(10, result, "Should return 10 and work with different delimiters");
	}

	/**
	 * Test 13
	 * should allow different delimiters
	 * "//;;,,\n1,,2;;3,,4"
	 */
	@Test
	public void shouldAllowMulticharDifferentDelimiters(){
		String numbers = "//;;,,\n1,,2;;3,,4";

		int result = stringCalculator.add(numbers);

		assertEquals(10, result, "Should return 10 and work with different multichar delimiters");
	}

	/**
	 * Test 14
	 * should throw exception when delimiters from outside the list used
	 * "//;;,,\n1,,2;;3__4"
	 */
	@Test
	public void shouldAllowDelimitersOnlyFromProvidedListOrDefaultIfNoList(){
		String numbers = "//;;,,\n1,,2;;3__4";

		try{
			int result = stringCalculator.add(numbers);
			fail("Delimiters from above the list used");
		} catch (Exception ex) {
			assertEquals("Delimiters outside of list used", ex.getMessage());
		}
	}
}
