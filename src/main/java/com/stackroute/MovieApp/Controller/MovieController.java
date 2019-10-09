package com.stackroute.MovieApp.Controller;

import com.stackroute.MovieApp.Services.MovieService;
import com.stackroute.MovieApp.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    MovieService movieService;

    public MovieController (MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("/getAllMovies")
    public ResponseEntity<?> getAllMovies(){
        ResponseEntity responseEntity;
        try {
            responseEntity= new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<?> deleteMovie(@RequestBody Movie movie,@PathVariable int id){
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity<String>("movie deleted successfully",HttpStatus.OK);

        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie ,@PathVariable int id){
        try {
            return new ResponseEntity<Movie>(movieService.updateMovie(movie,id),HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<?>getMovieById(@PathVariable int id){
        try {
            return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
        }
        catch (Exception e) {

            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/titles/{title}")
    public ResponseEntity<List<Movie>> getByName(@RequestParam   String title) {
        List<Movie> movie = movieService.getByName(title);
        return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);
    }
}
