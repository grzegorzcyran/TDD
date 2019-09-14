package junit.test.samples.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionManuallyTest {

	@Test
	public void testException() {
		try {
			throw new IllegalStateException(
					"exception message",
					new UnsupportedOperationException());

		} catch (Exception ex) {
			Assert.assertTrue(ex instanceof IllegalStateException);
			Assert.assertTrue(ex.getMessage().contains("mess"));
			Assert.assertTrue(ex.getCause() instanceof UnsupportedOperationException);
		}
	}
}
