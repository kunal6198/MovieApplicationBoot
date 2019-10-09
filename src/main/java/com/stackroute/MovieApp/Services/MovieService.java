package com.stackroute.MovieApp.Services;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies() throws MovieNotFoundException;
    public boolean deleteMovie(int id) throws MovieNotFoundException;
    public Movie updateMovie(Movie movie , int id) throws MovieNotFoundException;
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
    public List<Movie> getByName(String title);
}
