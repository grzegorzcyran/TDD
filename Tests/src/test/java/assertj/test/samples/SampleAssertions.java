package assertj.test.samples;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.assertj.core.data.Index;
import org.junit.Test;

public class SampleAssertions {

	@Test
	public void assertJExamples(){
		assertThat(Arrays.asList(1,2,3))
				.contains(1, Index.atIndex(0))
				.containsOnlyOnce(1, 2, 3);

		assertThat("Ala ma kota.").containsIgnoringCase("ma")
				.hasSize(12).endsWith("kota.");

		assertThat(LocalDate.parse("2018-09-15")).isBefore("2018-09-20")
				.isAfterOrEqualTo("2018-09-14");

		assertThatCode(() -> {double a = 0 / 2;}).doesNotThrowAnyException();

		assertThatExceptionOfType(ArithmeticException.class)
				.isThrownBy(() -> {double a = 2 / 0;});

		Film film1 = null;
		Film film2 = null;
		try {
			film1 = new Film("Rydwany ognia"
					, new SimpleDateFormat("yyyy-MM-dd").parse("1968-07-02"));
			film2 = new Film("Rydwany ognia"
					, new SimpleDateFormat("yyyy-MM-dd").parse("1968-09-02"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertThat(film1).isEqualToComparingOnlyGivenFields(film2,
				"title");
		assertThat(film1).isEqualToIgnoringGivenFields(film2,
				"releaseDate");
		assertThat(film1).isNotEqualTo(film2);
	}
}
