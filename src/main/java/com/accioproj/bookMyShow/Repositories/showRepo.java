package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.Movie;
import com.accioproj.bookMyShow.Entity.Show;
import com.accioproj.bookMyShow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface showRepo extends JpaRepository<Show,Integer> {
    Optional<Show> findByMovieAndTheaterAndShowDateAndShowTime(Movie movie, Theater theater, LocalDate showDate, LocalTime showTime);

    Optional<Show> findByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);

    List<Show> findByMovieAndShowDate(Movie movie, LocalDate showDate);








}
