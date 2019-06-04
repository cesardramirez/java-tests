package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieService {

    Collection<Movie> findMoviesByGenre(Genre genre);

    Collection<Movie> findMoviesByDuration(int length);

    Collection<Movie> findMoviesByName(String name);

    Collection<Movie> findMoviesByDirector(String director);
}
