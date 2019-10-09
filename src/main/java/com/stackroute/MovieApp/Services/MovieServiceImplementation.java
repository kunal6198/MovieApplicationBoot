package com.stackroute.MovieApp.Services;

import com.stackroute.MovieApp.domain.Movie;
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
    public Movie saveMovie(Movie movie)
    {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id){
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie , int id){
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(int id){
        Optional<Movie> movie = movieRepository.findById(id);
            return movie;
    }

    @Override
    public List<Movie> getByName(String title) {
        List<Movie> id = movieRepository.findTitleByName(title);
        return id;
    }
}
