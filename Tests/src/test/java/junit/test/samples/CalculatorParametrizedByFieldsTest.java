package junit.test.samples;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class CalculatorParametrizedByFieldsTest {

	@Parameterized.Parameter(value = 0)
	public int number1;
	@Parameterized.Parameter(value = 1)
	public int number2;
	@Parameterized.Parameter(value = 2)
	public int result;

	@Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{2, 2, 4},
				{2, 6, 8}
		});
	}

	@Test
	public void testAdd(){
		assertEquals(result, number1 + number2);
	}
}
