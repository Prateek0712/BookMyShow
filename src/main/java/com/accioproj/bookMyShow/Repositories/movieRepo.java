package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface movieRepo extends JpaRepository<Movie,Integer> {
    Optional<Movie> findByMovieName(String movieName);

}
