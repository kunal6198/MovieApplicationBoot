package com.stackroute.MovieApp.Services;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository)
    {
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie (Movie movie) throws MovieAlreadyExistsException
    {
        if(movieRepository.existsById(movie.getId())){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if (savedMovie == null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException{
        Optional<Movie> movieId = movieRepository.findById(id);
        if (movieId.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie , int id) throws MovieNotFoundException {
        Optional<Movie> userOptional = movieRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new MovieNotFoundException("Track not found!");
        }
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            return movie;
        }else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public List<Movie> getByName(String title) {
        List<Movie> id = movieRepository.findTitleByName(title);
        return id;
    }
}
