package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceShould {

    @InjectMocks
    MovieServiceImpl movieService;

    @Mock
    MovieRepository movieRepository;

    @Before
    public void setUp() {
        movieService = new MovieServiceImpl(movieRepository);
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, THRILLER, "Christopher Nolan"),
                new Movie(3, "There's Something About Mary", 119, COMEDY, "Peter y Bobby Farrelly"),
                new Movie(4, "Super 8", 112, THRILLER, "JJ Abrams"),
                new Movie(5, "Scream", 111, HORROR, "Wes Craven"),
                new Movie(6, "Home Alone", 103, COMEDY, "Chris Columbus"),
                new Movie(7, "Matrix", 136, ACTION, "Lana y Lilly Wachowski"),
                new Movie(8, "Superman", 169, ACTION, "Richard Donner")
        ));
    }

    @Test
    public void returnMoviesByGenre() {
//        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByDuration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(112);

        assertThat(getMovieIds(movies), is(Arrays.asList(4, 5, 6)));
    }

    @Test
    public void returnMoviesByName() {
        Collection<Movie> movies = movieService.findMoviesByName("Super");

        assertThat(getMovieIds(movies), is(Arrays.asList(4, 8)));
    }

    @Test
    public void returnMoviesByDirector() {
        Collection<Movie> movies = movieService.findMoviesByDirector("Nolan");

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2)));
    }

    @Test
    public void returnMoviesByMovieTemplateWithDurationAndGenre() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                new Movie(null, 152, ACTION, null)
            );

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 7)));
    }

    @Test
    public void returnMoviesByMovieTemplateWithNameAndDuration() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                new Movie("Super 8", 112, null, null)
            );

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));
    }

    @Test
    public void returnMoviesByMovieTemplateWithNameAndGenre() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                    new Movie("Super 8", null, THRILLER, null)
            );

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));
    }

    @Test
    public void returnMoviesByMovieTemplateWithNameAndGenreAndDuration() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                    new Movie("memento", 113, THRILLER, null)
            );

        assertThat(getMovieIds(movies), is(Collections.singletonList(2)));
    }

    @Test
    public void returnMoviesByMovieTemplateWithDirector() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                new Movie(null, null, null, "nolan")
            );

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void returnError_whenDurationIsNegative() {
        Collection<Movie> movies =
            movieService.findMoviesByTemplate(
                new Movie(null, -120, null, null)
            );

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}