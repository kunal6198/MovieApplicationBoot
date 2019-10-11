package com.stackroute.MovieApp.Services;

import com.stackroute.MovieApp.Services.MovieService;
import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service(value = "dummy")
public class TrackDummyServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Override
    public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getId())){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if (savedMovie == null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        System.out.println("Inside dummy service Impl saveMovie.");
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        System.out.println("Inside dummy service Impl getAllMovie.");
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
        Optional<Movie> movieId = movieRepository.findById(id);
        System.out.println("Inside dummy service Impl getId.");
        if (movieId.isPresent()){
            return movieId;
        }else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        Optional<Movie> movieId = movieRepository.findById(id);
        System.out.println("Inside dummy service Impl deleteById.");
        if (movieId.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie, int id) throws MovieNotFoundException {
        Optional<Movie> userOptional = movieRepository.findById(id);
        System.out.println("Inside dummy service movie Impl updateById");
        if(userOptional.isEmpty()){
            throw new MovieNotFoundException("Track not found!");
        }
        movie.setId(id);
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public List<Movie> getByName(String title) {
        List<Movie> id = movieRepository.findTitleByName(title);
        System.out.println("Inside dummy service Impl getByName.");
        return id;
    }

}