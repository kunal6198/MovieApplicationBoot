package com.stackroute.MovieApp.repository;

import com.stackroute.MovieApp.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
