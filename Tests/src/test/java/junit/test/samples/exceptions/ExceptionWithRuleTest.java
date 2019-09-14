package junit.test.samples.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionWithRuleTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testException(){
		Throwable cause = new UnsupportedOperationException();
		expectedException.expect(IllegalStateException.class);
		expectedException.expectMessage("mess");

		throw new IllegalStateException("exception message", cause);
	}
}
