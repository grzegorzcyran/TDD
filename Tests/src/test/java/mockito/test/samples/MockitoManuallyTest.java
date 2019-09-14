package mockito.test.samples;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;
import org.assertj.core.api.Assertions;

import assertj.test.samples.Film;

public class MockitoManuallyTest {

	@Test
	public void noFilmIsReturned(){
		//given
		FilmRepository filmRepository = Mockito.mock(FilmRepository.class);
		when(filmRepository.filmsWithAttribute("2d"))
				.thenReturn(Collections.emptyList());
		//when
		Set<Film> films = new HashSet<>(filmRepository.filmsWithAttribute("2d"));
		//then
		Assertions.assertThat(films).isEmpty();
		Mockito.verify(filmRepository,
				times(1)).filmsWithAttribute("2d");
	}

	@Test
	public void oneFilmIsReturned(){
		//given
		FilmRepository filmRepository = Mockito.mock(FilmRepository.class);
		Film film1 = null;
		try {
			film1 = new Film("Rydwany ognia"
					, new SimpleDateFormat("yyyy-MM-dd").parse("1968-07-02"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		when(filmRepository.filmsWithAttribute("2d")).thenReturn(Arrays.asList(film1));
		//when
		Set<Film> films = new HashSet<>(filmRepository.filmsWithAttribute("2d"));
		//then
		Assertions.assertThat(films).isNotEmpty();
		Mockito.verify(filmRepository,
				times(1)).filmsWithAttribute("2d");
	}

	@Test
	public void oneMockedFilmIsReturned(){
		//given
		FilmRepository filmRepository = Mockito.mock(FilmRepository.class);
		Film film1 = Mockito.mock(Film.class);

		when(filmRepository.filmsWithAttribute("2d"))
				.thenReturn(Arrays.asList(film1));

		//when
		Set<Film> films = new HashSet<>(filmRepository.filmsWithAttribute("2d"));
		//then
		Assertions.assertThat(films).isNotEmpty();
		Mockito.verify(filmRepository,
				times(1)).filmsWithAttribute("2d");
	}
}
