package com.accioproj.bookMyShow.Requests;

import com.accioproj.bookMyShow.Enums.Genre;
import com.accioproj.bookMyShow.Enums.Languege;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class addMovieRqst {
    private String movieName;
    private Languege movieLanguege;

    private Genre movieGenre;

    private String director;

    private LocalDate releaseDate;
    private Integer Duration;
}
