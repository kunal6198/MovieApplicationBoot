package com.stackroute.MovieApp.Services;

import com.stackroute.MovieApp.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public boolean deleteMovie(int id);
    public Movie updateMovie(Movie movie , int id);
    public Optional<Movie> getMovieById(int id);
}
