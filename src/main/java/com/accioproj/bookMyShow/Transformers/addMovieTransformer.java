package com.accioproj.bookMyShow.Transformers;

import com.accioproj.bookMyShow.Entity.Movie;
import com.accioproj.bookMyShow.Requests.addMovieRqst;

public class addMovieTransformer {
    public static Movie convertAddMovieRqsttoMovie(addMovieRqst movieRqst)
    {
        Movie movie= Movie.builder()
                .movieName(movieRqst.getMovieName())
                .movieLanguege(movieRqst.getMovieLanguege())
                .movieGenre(movieRqst.getMovieGenre())
                .director(movieRqst.getDirector())
                .releaseDate(movieRqst.getReleaseDate())
                .Duration(movieRqst.getDuration())
                .build();
        return movie;
    }
}
