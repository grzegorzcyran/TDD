package mockito.test.samples;

import java.util.List;

import assertj.test.samples.Film;

public interface FilmRepository {

	public List<Film> filmsWithAttribute(String attribute);

}
