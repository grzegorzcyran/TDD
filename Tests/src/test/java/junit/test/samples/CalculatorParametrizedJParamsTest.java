package junit.test.samples;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculatorParametrizedJParamsTest {

	private Calculator calculator;

	@Test
	@Parameters(
			{"1, 9, 10",
			"2, 2, 4"}
	)
	public void testAdd(
			//given
			int numberA, int numberB, int expectedResult){

		//when
		int result = calculator.add(numberA, numberB);
		//then
		assertEquals(expectedResult, result);

	}

	@Test
	@Parameters(
			{"5, 2, 3",
					"2, 2, 0"}
	)
	public void testSubstract(
			//given
			int numberA, int numberB, int expectedResult){

		//when
		int result = calculator.subtract(numberA, numberB);
		//then
		assertEquals(expectedResult, result);

	}

	@Before
	public void setup(){
		  calculator = new Calculator();
	}
}
