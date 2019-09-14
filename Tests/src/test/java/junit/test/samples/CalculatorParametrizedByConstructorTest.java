package junit.test.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class CalculatorParametrizedByConstructorTest {

	private int firstNumber;
	private int secondNumber;
	private int result;
	private int substractResult;

	public CalculatorParametrizedByConstructorTest(
			int firstNumber, int secondNumber, int result, int substractResult) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
		this.substractResult = substractResult;
	}

	//metoda generująca obiekty klasy CalculatorParametrizedByConstructorTest
	//pola klasy są ustawiane za pomocą poszczególnych obiektów
	// przechowywanych w liście
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		//Arrays.asList przekształca podaną tabelę obiektów w listę
		return Arrays.asList(
				//poniżej jest zdefiniowanie dwuwymiarowej tabeli obiektów
				new Object[][]{
						{1, 2, 3, 1},
						{3, 5, 8, 2}});
	}

	@Test
	public void testAdd(){
		assertEquals(result, firstNumber + secondNumber);
	}

	@Test
	public void testSubstract(){
		assertEquals(substractResult, secondNumber - firstNumber);
	}

}
